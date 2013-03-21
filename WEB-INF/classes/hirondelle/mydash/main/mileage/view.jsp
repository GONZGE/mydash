<c:set value='MileageAction' var='baseURL'/> 
<tags:setFormTarget using='${baseURL}' />

<%-- Form for adds and edits. --%>
<form action='${formTarget}' method="post" class="user-input"> 
  <w:populate using="itemForEdit"> 
   <input name="Id" type="hidden">
	<input name="EntryDate" type="hidden"> 
   <table align="center">
    <tr title='integer'>
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
<table class="report" title="Mileage" align="center"> 
 <caption>Mileage</caption>
 <tr>
  <th title="Line Number">#</th>
  <th title='Entry Date'>Entry Date</th>
  <th title='Mileage'>Mileage</th>
 </tr>
<w:alternatingRow> 
<c:forEach var="item" items="${itemsForListing}" varStatus="index">
 <tr class="row_highlight">
  <td title="Line Number">${index.count}</td>
  <td align='right'>
    <c:set value="${item.entryDate}" var="entryDate"/>
    <w:showDateTime name='entryDate' pattern='MMM DD YYYY'/>    
  </td>
  <td align="right">
   <fmt:formatNumber value="${item.mileage}" />
  </td>
 </tr>
</c:forEach>
</w:alternatingRow>
</table>

