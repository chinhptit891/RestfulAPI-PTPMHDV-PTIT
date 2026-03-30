package com.nhom11.resource;

import com.nhom11.model.DonHang;
import com.nhom11.service.DonHangService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/donhang")
public class DonHangResource {
    private DonHangService donHangService = new DonHangService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response taoDonHang(DonHang dh) {
        boolean thanhCong = donHangService.taoDonHang(dh);
        if (thanhCong) {
            return Response.status(Response.Status.CREATED).entity("{\"thongBao\": \"Tao don hang thanh cong\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Tao don hang that bai\"}").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response layDonHangTheoId(@PathParam("id") int id) {
        DonHang dh = donHangService.layDonHangTheoId(id);
        if (dh != null) {
            return Response.ok(dh).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("{\"thongBao\": \"Khong tim thay don hang\"}").build();
    }

    @GET
    @Path("/nguoidung/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response layDonHangCuaNguoiDung(@PathParam("id") int idNguoiDung) {
        List<DonHang> ds = donHangService.layDonHangCuaNguoiDung(idNguoiDung);
        return Response.ok(ds).build();
    }
}
