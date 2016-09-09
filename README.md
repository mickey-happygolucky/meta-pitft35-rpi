# Summary

meta-pitft35-rpi support to work [PiTFT3.5](https://learn.adafruit.com/adafruit-pitft-3-dot-5-touch-screen-for-raspberry-pi) on RPi/RPi2/RPi3.

Back porting [HX8357D driver](https://github.com/torvalds/linux/commit/9cd491e8c390d403bdf881808ef409d83266f4b2) to
meta-raspberrypi kernel.

This layer is unofficial.

## Dependency

This layer depends on:

```
URI: git://git.yoctoproject.org/meta-raspberrypi
branch: master
revision: HEAD
```

# How to use

You can use PiTFT3.5 with this layer.

If you want to use PiTFT3.5, edit your local.conf and add the line as follows:

```
RPI_PITFT35 = "1"

KERNEL_DEVICETREE_append = " pitft35-resistive-overlay.dtb"
```
