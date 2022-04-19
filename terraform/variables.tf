variable "resource_group_name" {
  default     = "TFproduction"
  description = "variable for resource group"
}
variable "resource_group_location" {
  default = "CentralIndia"
}
variable "virtual_network_name" {
  default = "vnet-prod"
}
variable "subnet_name" {
  default = "subnet-prod"
}
variable "public_ip_name" {
  default = "publicip-prod"
}
variable "network_security_group_name" {
  default = "nsg-prod"
}
variable "network_interface_name" {
  default = "nic-prod"
}
variable "linux_virtual_machine_name" {
  default = "ubuntu-prod"
}
