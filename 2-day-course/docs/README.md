# Beginner course

Ces cours ont été écrits via [Cleaver](https://github.com/jdan/cleaver).

Pour les modifier et mettre à jour le support HTML:
```
$ npm install -g cleaver
$ cleaver beginner.md
```

Il est même possible de mettre en place un watcher qui écoutera les différentes modifications faites
au support en temps réel:
```
$ cleaver watch beginner.md
```

## Un docker avec Scala
Voici un [conténaire Docker](https://hub.docker.com/r/hseeberger/scala-sbt/) avec Scala et SBT.

### Installation
```
$ docker build -t hseeberger/scala-sbt github.com/hseeberger/scala-sbt
```

### Utilisation
```
$ docker run -it --rm hseeberger/scala-sbt
```
