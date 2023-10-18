FROM gitpod/workspace-full:2023-10-13-16-25-39

SHELL ["/bin/bash", "-c"]
RUN source "/home/gitpod/.sdkman/bin/sdkman-init.sh"  \
    && sdk install java 17.0.8-zulu < /dev/null