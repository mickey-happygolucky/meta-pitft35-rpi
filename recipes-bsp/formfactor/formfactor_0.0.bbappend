RPI_PITFT35 ?= ""

do_install_append() {
    if [ "${RPI_PITFT35}" = "1" ]; then
        if [ -s ${D}${sysconfdir}/formfactor/machconfig ]; then
       	    . ${D}${sysconfdir}/formfactor/machconfig
       	    if [ "$HAVE_TOUCHSCREEN" = "1" ]; then
		return 0
	    fi
    	fi
	echo "HAVE_TOUCHSCREEN=1" >> ${D}${sysconfdir}/formfactor/machconfig
	sed -i 's/HAVE_TOUCHSCREEN=0/#HAVE_TOUCHSCREEN=0/' \
	    ${D}${sysconfdir}/formfactor/machconfig
    fi
}

