package com.nhom11.resource;

import com.nhom11.model.DienThoai;
import com.nhom11.service.DienThoaiService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/dienthoai")
public class DienThoaiResource {
    private DienThoaiService dienThoaiService = new DienThoaiService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response layTatCa() {
        List<DienThoai> ds = dienThoaiService.layTatCaDienThoai();
        return Response.ok(ds).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response layChiTiet(@PathParam("id") int id) {
        DienThoai dt = dienThoaiService.layDienThoaiTheoId(id);
        if (dt != null) {
            return Response.ok(dt).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("{\"thongBao\": \"Khong tim thay dien thoai\"}").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response themDienThoai(DienThoai dt) {
        boolean thanhCong = dienThoaiService.themDienThoai(dt);
        if (thanhCong) {
            return Response.status(Response.Status.CREATED).entity("{\"thongBao\": \"Them hoan tat\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Them that bai\"}").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response capNhatDienThoai(@PathParam("id") int id, DienThoai dt) {
        boolean thanhCong = dienThoaiService.capNhatDienThoai(id, dt);
        if (thanhCong) {
            return Response.ok("{\"thongBao\": \"Cap nhat thai cong\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Cap nhat that bai\"}").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response xoaDienThoai(@PathParam("id") int id) {
        boolean thanhCong = dienThoaiService.xoaDienThoai(id);
        if (thanhCong) {
            return Response.ok("{\"thongBao\": \"Xoa thanh cong\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Xoa that bai\"}").build();
    }
}
