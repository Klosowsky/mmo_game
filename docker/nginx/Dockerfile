FROM nginx:1.23.3-alpine

COPY . /app/

COPY ./docker/nginx/nginx.conf /etc/nginx/conf.d/default.conf
COPY ./client/index.html /usr/share/nginx/html/index.html
