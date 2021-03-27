# weather-service
A simple springboot microservice to retrieve weather data based on latitude and longitude

## TL:DR
This demo application connects to OpenWeatherMap api to retrieve current weather stats for a given location.
A docker image is built and pushed to docker hub.
Finally 3 replicas of the docker image are deployed in Google Kubernetes cluster.

### Scrrenshot of GCP console
![GCP dashboard](/images/gcp_console.png)

### Screenshot of a GET request on the GKE service
![GCP dashboard](/images/json_response.png)
