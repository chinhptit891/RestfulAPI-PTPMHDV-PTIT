package com.nhom11.resource;

import com.nhom11.model.NguoiDung;
import com.nhom11.service.NguoiDungService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/nguoidung")
public class NguoiDungResource {
    private NguoiDungService nguoiDungService = new NguoiDungService();

    @POST
    @Path("/dangky")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response dangKy(NguoiDung nd) {
        boolean thanhCong = nguoiDungService.dangKy(nd);
        if (thanhCong) {
            return Response.status(Response.Status.CREATED).entity("{\"thongBao\": \"Dang ky thanh cong\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"thongBao\": \"Dang ky that bai\"}").build();
    }

    @POST
    @Path("/dangnhap")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response dangNhap(NguoiDung nd) {
        NguoiDung nguoiDung = nguoiDungService.dangNhap(nd.getTenDangNhap(), nd.getMatKhau());
        if (nguoiDung != null) {
            return Response.ok(nguoiDung).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("{\"thongBao\": \"Sai thong tin dang nhap\"}").build();
    }
}
