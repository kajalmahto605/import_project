@GrabResolver(name='central', root='https://repo1.maven.org/maven2/')
@Grab('org.yaml:snakeyaml:2.0')

import org.yaml.snakeyaml.Yaml

def parseYaml(String yamlText) {
    def yaml = new Yaml()
    return yaml.load(yamlText)
}

return this
