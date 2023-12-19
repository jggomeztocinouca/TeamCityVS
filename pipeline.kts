import jetbrains.buildServer.configs.kotlin.*

version = "2023.11"

project {
    buildType {
        steps {
            dockerCompose {
                name = "Node contenerizado"
                file = "docker-compose.yaml"
            }
        }
        script {
            name = "Test de dependencias"
            scriptContent = "docker exec VS npm test"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE // Para ver la salida incluso si falla
        }
        script {
            name "Detener contenedor"
            scriptContent = "docker stop VS"
        }
        script {
            name "Eliminar contenedor"
            scriptContent = "docker rm VS"
        }
    }
}