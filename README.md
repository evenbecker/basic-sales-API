# Basic sales API

## Installation

#### Tech stack
<ul>
  <li>Maven</li>
  <li>Spring Boot 4</li>
   <li>HyperSQL</li>
   <li>Spring Data JPA</li>
   <li>JUnit to test</li>
</ul>



#### Endpoints
Requests and responses will all be in JSON. The application will run at ``http://localhost:8080`` which the endpoints are:
<table>
  <tr>
    <td><b>Route</td>
    <td>Method</td>
    <td>Role</td>
    <td>Body/Params</b></td>
  </tr>
  
  <tr>
    <td>/sales</td>
    <td>GET</td>
    <td>Get all sales</td>
    <td>-</td>
  </tr>
  
  <tr>
    <td>/sales</td>
    <td>POST</td>
    <td>Creates a sale. <i>Requires <b>Body</b></i>*</td>
    <td>value: number, <br/><br/>sellerId: number</td>
  </tr>
  
  <tr>
    <td>/sellers</td>
    <td>GET</td>
    <td>Get all sellers.</td>
    <td>-</td>
  </tr>
  
  <tr>
    <td>/sellers</td>
    <td>POST</td>
    <td>Creates a seller. <i>Requires <b>Body</b></i>*</td>
    <td>name: string</td>
  </tr>
  
  <tr>
    <td>/sellers/avg</td>
    <td>GET</td>
    <td>Retrieves a list containing seller Name, Sales Total and Average sales per day.  <i>Requires <b>Params</b></i>*</td>
    <td>begin: long(date), <br/><br/>end: long(date)</td>
  </tr>
    
  
</table>
