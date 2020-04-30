#!/bin/bash

# download the TIB_bwpluginauditsafe_6.1.0_v9_bwce-runtime.zip http://reldist.na.tibco.com/package/bwpluginauditsafe/6.1.0/V9.1-GA
# that the Dockerfile needs.

docker build -t reldocker.tibco.com/tci/tci-bw-plugin-auditsafe:decoupled-6.1.0.v9 .

docker login reldocker.tibco.com

docker push reldocker.tibco.com/tci/tci-bw-plugin-auditsafe:decoupled-6.1.0.v9

