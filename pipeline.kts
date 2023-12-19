import jetbrains.buildServer.configs.kotlin.*

version = "2023.11"

project {
    buildType {
        name = "Build"
        steps {
            dockerCommand {
                name = "Node contenerizado"
                commandType = build {
                    source = file {
                        path = "docker-compose.yaml"
                    }
                }
            }
            script {
                name = "Test de dependencias"
                scriptContent = "docker exec VS npm test"
            }
            script {
                name = "Detener contenedor"
                scriptContent = "docker stop VS"
            }
            script {
                name = "Eliminar contenedor"
                scriptContent = "docker rm VS"
            }
        }
    }
}
