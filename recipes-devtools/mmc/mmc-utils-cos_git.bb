SUMMARY = "Userspace tools for MMC/SD devices (Downstream version of Chromium OS Project)"
HOMEPAGE = "http://chromium.googlesource.com/chromiumos/third_party/mmc-utils.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://mmc.c;beginline=1;endline=17;md5=d7747fc87f1eb22b946ef819969503f0"

inherit update-alternatives

ALTERNATIVE_${PN} = "mmc"
ALTERNATIVE_PRIORITY = "5"

SRCBRANCH ?= "master"
SRCREV = "bcc3e2e4246431be511be3959a11cd9733bedd29"

PV = "0.1"

SRC_URI  = " \
    git://chromium.googlesource.com/chromiumos/third_party/mmc-utils.git;protocol=https;branch=${SRCBRANCH} \
    file://0001-lsmmc-replace-strncpy-with-memmove-on-overlapping-me.patch \
"

S = "${WORKDIR}/git"

CFLAGS_append_powerpc64 = " -D__SANE_USERSPACE_TYPES__"
CFLAGS_append_mips64 = " -D__SANE_USERSPACE_TYPES__"
CFLAGS_append_mips64n32 = " -D__SANE_USERSPACE_TYPES__"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 mmc ${D}${bindir}
}
