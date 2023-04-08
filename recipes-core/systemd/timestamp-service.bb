DESCRIPTION = "Poor mans RTC using timestamps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd

SRC_URI = "file://timestamp.service \
           file://load-timestamp.sh \
          "

do_install () {
	install -d ${D}/${bindir}

	install -m 0755 ${WORKDIR}/load-timestamp.sh ${D}/${bindir}

	install -d ${D}/${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/timestamp.service ${D}/${base_libdir}/systemd/system/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "timestamp.service"
