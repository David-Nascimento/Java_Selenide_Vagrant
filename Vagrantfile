# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.
  config.vm.box = "ubuntu/bionic64"
  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  config.vm.disk :disk, size: "30GB", primary: true

  config.vm.network "private_network", ip: "192.168.33.10"
  
  config.vm.network "forwarded_port", guest: 80, host: 80

  config.vm.provider "virtualbox" do |vb|
    #   # Display the VirtualBox GUI when booting the machine
    #   vb.gui = true
    #
    #   # Customize the amount of memory on the VM:
      vb.memory = "2048"
  end

  # Instalando e iniciando Jenkins
  config.vm.provision "docker" do |j|
     j.build_image "/vagrant/scripts/jenkins/.",
     inline: "sudo /vagrant/scripts/jenkins/jenkins_exec.sh"
  end

  # Instalação dos scripts de dependencias
  config.vm.provision "shell",
	  inline: "sudo /vagrant/scripts/docker.sh"
  config.vm.provision "shell",
	  inline: "chmod +x /vagrant/scripts/java_home.sh && sudo /vagrant/scripts/java_home.sh"
  config.vm.provision "shell",
    inline: "chmod +x /vagrant/scripts/group-docker.sh && sudo /vagrant/scripts/group-docker.sh"
  config.vm.provision :docker_compose, yml: "/vagrant/scripts/homol/docker-compose.yml", run: "always"
end