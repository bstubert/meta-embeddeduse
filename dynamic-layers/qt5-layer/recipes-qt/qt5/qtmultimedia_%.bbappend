do_install:append() {
    install -d ${D}${OE_QMAKE_PATH_PLUGINS}/videoimx6vivantevideonode
}
FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS}/videoimx6vivantevideonode"
