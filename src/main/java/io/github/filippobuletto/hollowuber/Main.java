package io.github.filippobuletto.hollowuber;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.container.DeploymentException;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

  public static void main(String[] args) throws Exception {
    try {
      // I'd like swarm
      Swarm container = new Swarm();
      container.withXmlConfig(Main.class.getClassLoader().getResource("standalone.xml"));
      // Start the container
      container.start();
      // Build an archive (war)
      JAXRSArchive jaxrsArchive = ShrinkWrap.create(JAXRSArchive.class)
          .addAsResource(EmptyAsset.INSTANCE, "/META-INF/beans.xml")
          .addPackages(true, "io.github.filippobuletto.hollowuber")
          .addAllDependencies();

      // Deploy the archive, please
      container.deploy(jaxrsArchive);
    } catch (DeploymentException e) {
      e.printStackTrace();
      System.exit(-1);
    }

  }

}
