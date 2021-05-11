package org.testcontainers.containers;

import lombok.NonNull;

import java.util.concurrent.Future;

/**
 * Variant of {@link GenericContainer} that allows a fixed port on the docker host to be mapped to a container port.
 *
 * <p><strong>Normally this should not be required, and Docker should be allowed to choose a free host port instead</strong>.
 * However, when a fixed host port is absolutely required for some reason, this class can be used to set it.</p>
 *
 * <p>Callers are responsible for ensuring that this fixed port is actually available; failure will occur if it is
 * not available - which could manifest as flaky or unstable tests.</p>
 */
@SuppressWarnings("PMD")
public class CustomFixedHostPortGenericContainer<SELF extends CustomFixedHostPortGenericContainer<SELF>>
    extends GenericContainer<SELF> {

  public CustomFixedHostPortGenericContainer(@NonNull final Future<String> image) {
    super(image);
  }

  /**
   * Bind a fixed TCP port on the docker host to a container port
   * @param hostPort          a port on the docker host, which must be available
   * @param containerPort     a port in the container
   * @return this container
   */
  public SELF withFixedExposedPort(int hostPort, int containerPort) {

    return withFixedExposedPort(hostPort, containerPort, InternetProtocol.TCP);
  }

  /**
   * Bind a fixed port on the docker host to a container port
   * @param hostPort          a port on the docker host, which must be available
   * @param containerPort     a port in the container
   * @param protocol          an internet protocol (tcp or udp)
   * @return this container
   */
  public SELF withFixedExposedPort(int hostPort, int containerPort, InternetProtocol protocol) {

    super.addFixedExposedPort(hostPort, containerPort, protocol);

    return self();
  }

}
