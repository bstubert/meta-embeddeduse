FILESEXTRAPATHS:prepend := "${THISDIR}/u-boot-fw-utils:"
SRC_URI += "file://001-fix-block-device-in-fw-env.patch;patchdir=${WORKDIR};striplevel=5"
