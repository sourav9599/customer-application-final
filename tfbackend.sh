#!/bin/bash

RESOURCE_GROUP_NAME=TFstatebackup
STORAGE_ACCOUNT_NAME=tfstatebackupstorage
CONTAINER_NAME=tfstate
STATE_FILE="terraform.state"

az group create --name $RESOURCE_GROUP_NAME --location CentralIndia

az storage account create --resource-group $RESOURCE_GROUP_NAME --name $STORAGE_ACCOUNT_NAME --sku Standard_LRS --encryption-services blob

ACCOUNT_KEY=$(az storage account keys list --resource-group $RESOURCE_GROUP_NAME --account-name $STORAGE_ACCOUNT_NAME --query '[0].value' -o tsv)

az storage container create --name $CONTAINER_NAME --account-name $STORAGE_ACCOUNT_NAME --account-key $ACCOUNT_KEY

az keyvault create --name "tfbackupstatekeyvault" --resource-group "TFstatebackup" --location CentralIndia

az keyvault secret set --vault-name "tfbackupstatekeyvault" --name "tstateaccess" --value {$ACCOUNT_KEY}

az keyvault secret show --vault-name "tfbackupstatekeyvault" --name "tstateaccess"

