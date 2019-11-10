#!/usr/bin/env bash

echo "Stopping all containers..."
docker stop $(docker ps -a -q)

read -p "Press a key to continue ..."
