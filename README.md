# SBA Logistics Data Space

This Logistics Data space is an implementation of a dataspace that leverages the [Eclipse Dataspace Components (EDC)](https://github.com/eclipse-edc). It's a starting point for developing data space for logistics industry.
As a fully decentralized dataspace is hard to imagine, this data space serves the purpose of demonstrating how decentralization can be practically implemented.

## Running process

To run the SBA Logistics Data Space, you need to have Docker installed and running in your system, then:

1. Unzip the `SbaLogisticsDataspace` folder.
2. Get the sub folder name `frontend` full path.
3. Open terminal at the folder and entrer this command: `export SBA_CONNECTOR_UI="frontend_folder_full_path"`
4. Then run the command: `docker compose --profile ui -f system-tests/docker-compose.yml up --build`
5. After running, each company should access to the SBA Logistics Data Space through the Logisctis Connector.

### Test of the running SBA Logistics Data Space

There are already three(3) Companies in the Data Space, company1, company2 and company3, to test all the available functions of the SBA Logistics Data Space:

-   Company1's Logistics Connector is available at the `http://localhost:7080/`
-   Company2's Logistics Connector is available at the `http://localhost:7081/`
-   Company2's Logistics Connector is available at the `http://localhost:7082/`

### CLI TOOLS (For Dev only)

There's container `cli-tools` to turn into the state `healthy` after registering successfully all participants and will keep running as an entrypoint to the services created by Docker compose. This is useful for local development in order to manually check commands against the participants (e.g. `company1`, `company2`, `company3`).

Sample how to enter the container `cli-tools` and test a command manually.

Host:

```bash
docker exec -it cli-tools bash
```

Container:

```bash
java -jar registration-service-cli.jar \
>    -d=did:web:did-server:registration-service \
>    --http-scheme \
>    -k=/resources/vault/company1/private-key.pem \
>    -c=did:web:did-server:company1 \
>    participants get
```

Output (container)

```json
{
    "did": "did:web:did-server:company1",
    "status": "ONBOARDED"
}
```

### Run A Standard Scenario Locally

Prerequisite: create a test document manually:

-   Connect to the **local** blob storage account (provided by Azurite) of company1.
    -   Storage account name: `company1assets`, storage account key: `key1`.
    -   [Microsoft Azure Storage Explorer](https://azure.microsoft.com/features/storage-explorer/) can be used to connect to the local
        storage account on `localhost:10000`.
-   Create a container named `src-container`.
-   Copy [deployment/azure/terraform/modules/participant/sample-data/text-document.txt](deployment/azure/terraform/modules/participant/sample-data/text-document.txt) into the newly created container.
    -   N.B.: it does not have to be this exact file as long you create a file which has the name `text-document.txt`.

All this can also be done using Azure CLI with the following lines from the root of the MVD repository:

```bash
conn_str="DefaultEndpointsProtocol=http;AccountName=company1assets;AccountKey=key1;BlobEndpoint=http://127.0.0.1:10000/company1assets;"
az storage container create --name src-container --connection-string $conn_str
az storage blob upload -f ./deployment/azure/terraform/modules/participant/sample-data/text-document.txt --container-name src-container --name text-document.txt --connection-string $conn_str
```

This should result in a similar output as follows. Via the Microsoft Azure Storage Explorer it would be possible to
review the new container and the uploaded blob.

```bash
{
  "created": true
}

Finished[#############################################################]  100.0000%
{
  "etag": "\"0x1CC7CAB96842160\"",
  "lastModified": "2022-08-08T15:14:01+00:00"
}
```

The following steps initiate and complete a file transfer with the provided test document.

-   Open the website of company1 (e.g. <http://localhost:7080>) and verify the existence of two assets in the
    section `Assets`.
-   Open the website of the company2 (e.g. <http://localhost:7081>) and verify six existing assets from all participants in
    the `Catalog Browser`.
    -   In the `Catalog Browser` click `Negotiate` for the asset `test-document_company1`.
        -   There should be a message `Contract Negotiation complete! Show me!` in less than a minute.
-   From the previous message click `Show me!`. If you missed it, switch manually to the section `Contracts`.
    -   There should be a new contract. Click `Transfer` to initiate the transfer process.
    -   A dialog should open. Here, select as destination `AzureStorage` and click `Start transfer`.
    -   There should be a message `Transfer [id] complete! Show me!` in less than a minute. (Where `id` is a UUID.)
-   To verify the successful transfer the Storage Explorer can be used to look into the storage account of `company2`.
    -   Storage account name and key is set in `system-tests/docker-compose.yml` for the service `azurite`. Default name
        is `company2assets`, key is `key2`.
    -   There should be new container in the storage account containing two files `.complete` and `text-document.txt`.

## Done by

[Diallo Mamadou Alpha 苏泽](https://misterdiallo.github.io/) from the SBA Lab at [Linyi University](https://www.lyu.edu.cn/).
