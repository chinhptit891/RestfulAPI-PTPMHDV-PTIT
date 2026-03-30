package com.nhom11.resource;

import com.nhom11.model.Hang;
import com.nhom11.service.HangService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hang")
public class HangResource {
    private HangService hangService = new HangService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response layTatCaHang() {
        List<Hang> danhSach = hangService.layTatCaHang();
        return Response.ok(danhSach).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response themHang(Hang hang) {
        boolean thanhCong = hangService.themHang(hang);
        if (thanhCong) {
            return Response.status(Response.Status.CREATED).entity(hang).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Loi them hang\"}").build();
    }
}
