do_deploy_pitft35() {

# hifiberry DAC
    if [ -n "${RPI_PITFT35}" ]; then
        echo "# Enable PiTFT 3.5 Display" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=pitft35-resistive" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi
}

addtask deploy_pitft35 before do_package after do_deploy
