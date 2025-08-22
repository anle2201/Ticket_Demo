package com.example.pro6.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;

public interface TicketMessageResponse {
@Data
    class All {

    private Long id;
    private Long soGCN;
    private String nghiepVu;
    private String sdt;
    private String tenKH;
    private String ngayHL;
    private String ngayHetHL;
    private String bienSoXe;
    private String soKhung;
    private Long ticketId;
    private String tenNguoiThongBao;
    private String sdtNguoiThongBao;
    private String sdtLienHe;
    private String soGCNBaoHiem;
    private String nguoiThongBao;
    private String loaiHinh;
    private String loaiHinhNghiepVu;
    private String hienTruong;
    private String ngayTonThat;

//    @JsonFormat(pattern = "HH:mm")
    private String gioTonThat;

    private String diaDiemTonThat;
    private String moTaTonThat;
    private String laiXe;
    private String tinhThanh;
    private String phuongXa;
    private String hauQua;
    private String nhomNguyenNhan;
    private String hauQuaBenThuBa;
    private String diaDiemGiamDinh;
    private String giamDinhVien;
    private String sdtGiamDinhVien;
    private String idTongDaiVien;
    private String sdtChuXe;
    private String ghiChu;
    private String diaChiSuaChua;
    private String emailGRSR;
    private String email247;
    private String passMail247;
    private String email;
    private String donViCap;
    private String ngayMICHoSo;
    private String noiDung;
    private String emailCanBoXuLy;
    private String noiDungEmail;
    private String tongDaiVienXuLy;
    private String trangThaiXuLy;
    private String nguoiLienHe;
    private String diaChi;
    private String noiDungCauHoi;
    private String noiDungTraoDoi;
    private String loaiLuaChon;
    private String nguyenNhanChiTiet;
    private Boolean isGiamDinhTrungDiaDiem = false;
    private String diaDiemDeNghi;
}
    @Data
    class Detail {
        private Long id;

        private Long soGCN;

        private String sdt;

        private String tenKH;

        private String ngayHL;

        private String bienSoXe;

        private Long ticketId;

        private String soKhung;

        private String ngayHetHL;

    }
    @Data
    class CustomerDetail{
        private String tenKH;
        private String sdt;
        private String email;
        private String bienSoXe;
        private String donViCap;
        private String ngayHL;
        private String ngayHetHL;
        private String loaiLuaChon;
    }
    @Data
    class AccidentDetail{
        private String nghiepVu;
        private String loaiHinh;
        private String loaiHinhNghiepVu;
        private String hienTruong;
        private String bienSoXe;
        private String soGCNBaoHiem;
        private String nguoiThongBao;
        private String tenNguoiThongBao;
        private String sdtNguoiThongBao;
        private String sdtLienHe;
        private String ngayTonThat;
        private String gioTonThat;
        private String laiXe;
        private String tinhThanh;
        private String phuongXa;
        private String diaDiemTonThat;
        private String hauQua;
        private String moTaTonThat;
        private String nhomNguyenNhan;
        private String hauQuaBenThuBa;
        private String diaDiemGiamDinh;
        private String giamDinhVien;
        private String sdtGiamDinhVien;
        private String ghiChu;
        private String idTongDaiVien;
        private String sdtChuXe;
        private String diaChiSuaChua;
        private String emailGRSR;
        private String email247;
        private String passMail247;
        private String loaiLuaChon;
        private String nguyenNhanChiTiet;
        private Boolean isGiamDinhTrungDiaDiem = false;
        private String diaDiemDeNghi;
}
    @Data
    class ComplaintsDetail{
        private String tenKH;
        private String sdt;
        private String nghiepVu;
        private String ngayTonThat;
        private String gioTonThat;
        private String ngayMICHoSo;
        private String noiDung;
        private String emailCanBoXuLy;
        private String noiDungEmail;
        private String tongDaiVienXuLy;
        private String trangThaiXuLy;
        private String ghiChu;
        private String loaiLuaChon;
    }

   @Data
   class ProductDetail{
       private String nguoiLienHe;
       private String diaChi;
       private String noiDungCauHoi;
       private String nghiepVu;
       private String emailCanBoXuLy;
       private String noiDungEmail;
       private String tongDaiVienXuLy;
       private String ghiChu;
       private String loaiLuaChon;
   }
  @Data
  class OtherDetail{
      private String nguoiLienHe;
      private String noiDungTraoDoi;
      private String diaChi;
      private String tongDaiVienXuLy;
      private String ghiChu;
      private String loaiLuaChon;
  }

}





