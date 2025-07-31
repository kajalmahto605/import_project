import org.yaml.snakeyaml.Yaml
import java.net.URLClassLoader


def jarFile = new File("${WORKSPACE}/jenkis-libs/yaml/snakeyaml-2.0.jar")
if (jarFile.exists()) {
    def loader = this.class.classLoader
    if (loader instanceof groovy.lang.GroovyClassLoader) {
        loader.addURL(jarFile.toURI().toURL())
    } else {
        throw new Exception("Unable to load jar into classloader")
    }
} else {
    throw new FileNotFoundException("Missing snakeyaml jar at: ${jarFile}")
}


def parseYaml(String yamlText) {
    def yaml = new org.yaml.snakeyaml.Yaml()
    return yaml.load(yamlText)
}
