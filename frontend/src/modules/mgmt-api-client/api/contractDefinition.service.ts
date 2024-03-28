/**
 * Logistics Connector REST API
 * Logistics Connector REST APIs - merged by OpenApiMerger
 *
 * The version of the OpenAPI document: 0.0.1-SNAPSHOT
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
/* tslint:disable:no-unused-variable member-ordering */

import { Injectable } from '@angular/core';
import { HttpResponse, HttpEvent, HttpContext } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { EdcConnectorClient } from '@think-it-labs/edc-connector-client';
import { ContractDefinitionInput, ContractDefinition, IdResponse, QuerySpec } from "../model"


@Injectable({
  providedIn: 'root'
})
export class ContractDefinitionService {

    private contractDefinitions = this.edcConnectorClient.management.contractDefinitions;

    constructor(private edcConnectorClient: EdcConnectorClient) {
    }

    /**
     * Creates a new contract definition
     * @param input
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createContractDefinition(input: ContractDefinitionInput, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<IdResponse>;
    public createContractDefinition(input: ContractDefinitionInput, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpResponse<IdResponse>>;
    public createContractDefinition(input: ContractDefinitionInput, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpEvent<IdResponse>>;
    public createContractDefinition(input: ContractDefinitionInput): Observable<any> {
        return from(this.contractDefinitions.create(input));
    }

    /**
     * Removes a contract definition with the given ID if possible. DANGER ZONE: Note that deleting contract definitions can have unexpected results, especially for contract offers that have been sent out or ongoing or contract negotiations.
     * @param id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public deleteContractDefinition(id: string, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<any>;
    public deleteContractDefinition(id: string, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpResponse<any>>;
    public deleteContractDefinition(id: string, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpEvent<any>>;
    public deleteContractDefinition(id: string): Observable<any> {
      if (id === null || id === undefined) {
          throw new Error('Required parameter id was null or undefined when calling deleteContractDefinition.');
      }

      return from(this.contractDefinitions.delete(id))
    }

    /**
     * Gets an contract definition with the given ID
     * @param id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getContractDefinition(id: string, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<ContractDefinition>;
    public getContractDefinition(id: string, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpResponse<ContractDefinition>>;
    public getContractDefinition(id: string, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpEvent<ContractDefinition>>;
    public getContractDefinition(id: string): Observable<any> {
        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling getContractDefinition.');
        }

        return from(this.contractDefinitions.get(id))
    }

    /**
     * Returns all contract definitions according to a query
     * @param querySpec
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public queryAllContractDefinitions(querySpec?: QuerySpec, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<Array<ContractDefinition>>;
    public queryAllContractDefinitions(querySpec?: QuerySpec, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpResponse<Array<ContractDefinition>>>;
    public queryAllContractDefinitions(querySpec?: QuerySpec, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext}): Observable<HttpEvent<Array<ContractDefinition>>>;
    public queryAllContractDefinitions(querySpec?: QuerySpec): Observable<any> {
        return from(this.contractDefinitions.queryAll(querySpec))
    }

}
