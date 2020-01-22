# Datomic test

## Requirements

- Docker
- [VSCode Remote - Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

## How to start

1. Register Datomic and get download key and license key https://my.datomic.com/account
2. Clone this repo

```
$ git clone https://github.com/mtsmfm/datomic-test
$ cd datomic-test
```

3. Copy and fill DATOMIC_HTTP_USER, DATOMIC_HTTP_PASSWORD and LICENSE_KEY

```
$ cp .devcontainer/docker-compose.local.yml.example .devcontainer/docker-compose.local.yml
$ code .devcontainer/docker-compose.local.yml
```

4. Click "Reopen in Container" in VSCode
