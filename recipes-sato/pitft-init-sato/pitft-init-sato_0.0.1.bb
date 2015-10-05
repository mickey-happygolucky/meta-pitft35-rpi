LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

S = "${WORKDIR}"

FILES_${PN} = "${sysconfdir}/profile.d \
	       ${sysconfdir}/modules-load.d \
	       ${sysconfdir}/X11/xorg.conf.d \
"

S = "${WORKDIR}"

# NOTE: no Makefile found, unable to determine what needs to be done
do_install () {
	# Install the script which set the framebuffer to /dev/fb1
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/profile.d
	echo "#!/bin/sh" > ${D}${sysconfdir}/profile.d/pitft.sh
	echo "export FRAMEBUFFER=/dev/fb1" >> ${D}${sysconfdir}/profile.d/pitft.sh

	# Install the script which load touchscreen driver
	install -d ${D}${sysconfdir}/modules-load.d
	echo "stmpe-ts" > ${D}${sysconfdir}/modules-load.d/stmpe-ts.conf


	# Install the file which calibrating touch screen for X11
	install -d ${D}${sysconfdir}/X11
	install -d ${D}${sysconfdir}/X11/xorg.conf.d
	echo 'Section	"InputClass"' > ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		Identifier		"calibration"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		MatchProduct	"stmpe-ts"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		Option	"Calibration"	"3800 120 200 3900"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		Option	"SwapAxes"		"1"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		Option	"InvertX"		"true"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo '		Option	"InvertY"		"true"' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
	echo 'EndSection' >> ${D}${sysconfdir}/X11/xorg.conf.d/99-calibration.conf
}
