# DDD (Domain-Driven Design)
## Domain
 - Is business rule.
 - According to Erick Evans, understand the Domain is the key to implement DDD in a project.
  
## Oblique Language
 - Oblique language is the common langue to dev team and business team.
 - Business team doesn't know tec terms and we doesnt know some business terms .

## Bounded Context
 - A bounded context is a part of all workflow.

## Context Map
 - Context map is all workflow, to make a overview of it.

### Shared Kernel
 - Shared Kernel is a relationship between the contexts where various bounded context use same domain, so if this domain is changed in one bounded context, it will be changed in all the others
  
### Customer-Supplier Development
 - Is a relationship client-supplier
 - Have two contexts, upstream and downstream
   - upstream: Supplier
   - downstream: Consumer
 - In this case, consumer developers can write tests with supplier interfaces, with this, the supplier can do changes without compatibility errors

### Conformist
 - When upstream doesnt meet the downstream requirements and downstream need to watch all changes made by upstream

### Parter
 - The bounded contexts need to work together

### Anticorruption Layer
 - In this relationship, downstream create a layer to protect the context from upstream changes

## Agregates
 - Define border between the objects

## Models
 - Models is the ways to represent things in a domain (entitites, services, diagrams)

## Domain Services
 - Is an service where use more than 1 domain

## Repositories
 - Is a pattern to isolate the logic to persist data (to do the CRUD)
 - In java, we have @Repository annotation in interfaces, to persist data.