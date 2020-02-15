FROM clojure

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

RUN apt-get update \
  && apt-get install -y zsh less autossh git

RUN useradd --create-home --user-group --uid 1000 app
RUN mkdir -p /app /original
RUN chown -R app /app /original

WORKDIR /app

USER app

ENV SHELL=/bin/zsh BUNDLE_PATH=/app/vendor/bundle HOME=/home/app
