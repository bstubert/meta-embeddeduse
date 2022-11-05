FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += "file://rndis.network"

PACKAGECONFIG_append = " networkd"

PACKAGECONFIG[acl] = "-Dacl=true,-Dacl=false,acl"

do_install_append() {
    # The network files need to be in /usr/lib/systemd, not ${systemd_unitdir}...
    install -d ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${WORKDIR}/rndis.network ${D}${prefix}/lib/systemd/network/
}

FILES_${PN} += " \
    ${nonarch_base_libdir}/systemd/network \
"
