#!/usr/bin/env bash

echo "Stopping all containers..."
docker stop $(docker ps -a -q)
echo "Removing all containers..."
docker container prune -f
echo "Removing all images..."
docker image prune -a -f
echo "Removing all volumes..."
docker volume prune -f
echo "Removing all networks..."
docker network prune -f
echo "Removing all cache..."
docker system prune -f

read -p "Press a key to continue ..."
