### AutoBots - Automanager

#### Pré-requisitos

- JDK 17 instalado e `JAVA_HOME` apontando para essa versão.

#### Como rodar

Execute os comandos a partir da pasta do projeto.

#### Windows (PowerShell)

```powershell
cd automanager
# Ajuste o caminho se o JDK 17 estiver em outra pasta.
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-17'
.\mvnw.cmd spring-boot:run
```

Se o Maven tentar usar `C:\.m2` ou exibir erro de acesso ao repositório local, execute:

```powershell
$env:MAVEN_USER_HOME = "$env:USERPROFILE\.m2"
.\mvnw.cmd "-Dmaven.repo.local=$env:USERPROFILE\.m2\repository" spring-boot:run
```

#### Linux/macOS

Com `JAVA_HOME` configurado para o JDK 17:

```bash
cd automanager
sh ./mvnw spring-boot:run
```

A API fica disponível em `http://localhost:8080`. Para encerrar, pressione `Ctrl+C` no terminal em que ela está rodando.

O banco H2 é criado em memória e preenchido com um cliente de exemplo na inicialização. Os dados são perdidos ao encerrar a aplicação.

#### Testes

Na pasta `automanager`, com o JDK 17 configurado:

```powershell
# Windows
.\mvnw.cmd test

# Se for necessário especificar o repositório local:
.\mvnw.cmd "-Dmaven.repo.local=$env:USERPROFILE\.m2\repository" test
```

```bash
# Linux/macOS
sh ./mvnw test
```


