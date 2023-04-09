# set the following variable to your one and only application which should
# be launched right after weston started

INITIAL_APP_PKGS ?= "weston"
INITIAL_PATH ?= ""
WAYLAND_APPLICATION ?= "/usr/bin/weston-terminal"

require wayland-app-launch.inc
