# set the following variable to your one and only application which should
# be launched right after weston started

INITIAL_APP_PKGS ?= "cuteradio"
INITIAL_PATH ?= ""
APPLICATION_ENVIRONMENT ?= '\"QT_QPA_PLATFORM=wayland-egl\"'
WAYLAND_APPLICATION ?= "/usr/bin/cuteradio"

require wayland-app-launch.inc
