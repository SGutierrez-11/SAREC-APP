# Login to Docker Hub to authenticate and push Docker images
docker login

# Build a Docker image with the specified tag (-t) and Dockerfile in the current directory
docker build -t danieljaraba/sarec-backend:latest .

# Tag the locally built image with the latest tag before pushing it to the repository
docker tag danieljaraba/sarec-backend:latest danieljaraba/sarec-backend:latest

# Push the locally built and tagged image to the Docker Hub repository
docker push danieljaraba/sarec-backend:latest