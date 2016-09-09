FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.18:"

SRC_URI += "file://support_rpi_pitft35.patch \
	"

# CMDLINE for raspberrypi with pitft
CMDLINE_PITFT = "dwc_otg.lpm_enable=0 console=ttyAMA0,115200 kgdboc=ttyAMA0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait fbcon=map:10 fbcon=font:VGA8x8"


do_defconfig_pitft35() {
    if ! grep "CONFIG_FB_TFT_HX8357D=m" ${WORKDIR}/defconfig ; then
       echo 'CONFIG_FB_TFT_HX8357D=m' >> ${WORKDIR}/defconfig
    fi
}

do_deploy_append() {
    # Deploy cmdline.txt
    install -d ${DEPLOYDIR}/bcm2835-bootfiles
    echo "${CMDLINE_PITFT}" > ${DEPLOYDIR}/bcm2835-bootfiles/cmdline.txt
}

addtask defconfig_pitft35 before do_configure after do_kernel_configme
