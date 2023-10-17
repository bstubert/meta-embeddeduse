SUMMARY = "CuteRadio - Simple Internet radio for showing QML and Qt on embedded systems"
AUTHOR = "Burkhard Stubert (burkhard.stubert@embeddeduse.com)"
HOMEPAGE = "https://github.com/bstubert/cuteradio-apps"

SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ef68d7e526c164e11da8965fdbed52c"

inherit cmake_qt5

SRC_URI = "\
    git://github.com/bstubert/cuteradio-apps.git;branch=qt5;protocol=https \
"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative qtdeclarative-native qtquickcontrols2 qtmultimedia"
RDEPENDS:${PN} = "qtdeclarative-qmlplugins qtquickcontrols2-qmlplugins qtmultimedia-qmlplugins"