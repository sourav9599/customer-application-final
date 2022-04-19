output "vm_username" {
  value = azurerm_linux_virtual_machine.linuxvm.admin_username
}
output "vm_password" {
  value = azurerm_linux_virtual_machine.linuxvm.admin_password
  sensitive = true
}

output "vm_ip" {
  value = azurerm_linux_virtual_machine.linuxvm.public_ip_address
}

output "tls_private_key" {
  value = tls_private_key.example_ssh.private_key_pem
  sensitive = true
}