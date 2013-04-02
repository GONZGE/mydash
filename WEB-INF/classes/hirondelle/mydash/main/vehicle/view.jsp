<c:set value='VehicleAction' var='baseURL'/> 
<tags:setFormTarget using='${baseURL}' />

<%-- Form for adds and edits. --%>
<form action='${formTarget}' method="post" class="user-input"> 
  <w:populate using="itemForEdit"> 
   <input name="Id" type="hidden">
   <table align="center">
       <tr title="Vehicle Name">
           <td><label>Vehicle Name *</label></td>
           <td><input name="VehicleName" type="text" maxlength="32"></td>
       </tr>
       <tr title="Vehicle Make">
           <td><label>Make *</label></td>
           <td><input name="VehicleMake" type="text" maxlength="32"></td>
       </tr>
       <tr title="Vehicle Model">
           <td><label>Model *</label></td>
           <td><input name="VehicleModel" type="text" maxlength="32"></td>
       </tr>
       <tr title="Vehicle Year.  Format: YYYY">
           <td><label>Year (YYYY) *</label></td>
           <td><input name="VehicleYear" type="text" maxlength="4"></td>
       </tr>
    <tr title="integer">
     <td><label>Mileage *</label></td>
     <td><input name="Mileage" type="text"  maxlength='10'></td>
    </tr>
    <tr>
     <td align="center" colspan=2>
      <input type='submit' value="Add/Edit">
     </td>
    </tr>
   </table>
  </w:populate>
</form>

</form>

<P>
<%-- Listing of all items. --%>
<table class="report" title="Vehicles" align="center"> 
 <caption>Vehicles</caption>
 <tr>
  <th title="Line Number">#</th>
  <th title="Vehicle Name">Name</th>
  <th title="Vehicle Make">Make</th>
  <th title="Vehicle Model">Model</th>
  <th title="Vehicle Year">Year</th>
  <th title="Mileage">Mileage</th>
 </tr>
<w:alternatingRow> 
<c:forEach var="item" items="${itemsForListing}" varStatus="index">
 <tr class="row_highlight">
  <td title="Line Number">${index.count}</td>
  <td align="left">
    ${item.vehicleName}
  </td>
  <td align="left">
      ${item.vehicleMake}
  </td>
  <td align="left">
      ${item.vehicleModel}
  </td>
  <td align="left">
      ${item.vehicleYear}
  </td>
  <td align="right">
   <fmt:formatNumber value="${item.mileage}" />
  </td>
    <tags:editLinksFineGrained baseURL='${baseURL}' id='${item.id}'/>
 </tr>
</c:forEach>
</w:alternatingRow>
</table>

