# Tests of the page called Fantasmania

## How to run

### Step 1:
Clone repo, open terminal in the folder.

### Step 2:
Start docker environment.

``` 
docker compose up
docker exec -it selenium-testing-big-assignment-ubuntu-1 bash
```

### Step 3 (not required):
Open the `localhost:8081` page in a browser, to inspect the tests while running. 

### Step 4:
Run the tests.

`cd tests`

`gradle test`
