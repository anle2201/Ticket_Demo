package com.example.pro6.Model;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "ticket_message")
public class TicketMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, name = "certificate")
    private Long soGCN;

    @Column(nullable = true, name = "profession")
    private String nghiepVu;

    @Column(nullable = true, name = "phone")
    private String sdt;

    @Column(nullable = true, name = "customer")
    private String tenKH;

    @Column(nullable = true, name = "email")
    private String email;

    @Column(nullable = true, name = "company")
    private String donViCap;

    @Column(nullable = true, name = "start_date")
    private String ngayHL;

    @Column(nullable = true, name = "end_date")
    private String ngayHetHL;

    @Column(nullable = true, name = "vehicle_number")
    private String bienSoXe;

    @Column(nullable = true, name = "frame_number")
    private String soKhung;

    @Column(nullable = true, name = "ticket_id")
    private Long ticketId;

    @Column(nullable = true, name = "announcer_name")
    private String tenNguoiThongBao;

    @Column(nullable = true, name = "announcer_phone")
    private String sdtNguoiThongBao;

    @Column(nullable = true, name = "contact_phone")
    private String sdtLienHe;

    @Column(nullable = true, name = "insurance_certificate")
    private String soGCNBaoHiem;

    @Column(nullable = true, name = "announcer")
    private String nguoiThongBao;

    @Column(nullable = true, name = "type")
    private String loaiHinh;

    @Column(nullable = true, name = "type_profession")
    private String loaiHinhNghiepVu;

    @Column(nullable = true, name = "scene")
    private String hienTruong;

    @Column(name = "accident_date", nullable = true )
    private String ngayTonThat;

    @Column(nullable = true, name = "accident_time")
    private String gioTonThat;

    @Column(nullable = true, name = "accident_address")
    private String diaDiemTonThat;

    @Column(nullable = true, name = "accident_description")
    private String moTaTonThat;

    @Column(nullable = true, name = "driver")
    private String laiXe;

    @Column(nullable = true, name = "city")
    private String tinhThanh;

    @Column(nullable = true, name = "ward")
    private String phuongXa;

    @Column(nullable = true, name = "effect")
    private String hauQua;

    @Column(nullable = true, name = "cause_group")
    private String nhomNguyenNhan;

    @Column(nullable = true, name = "effect_third")
    private String hauQuaBenThuBa;

    @Column(nullable = true, name = "inspection_location")
    private String diaDiemGiamDinh;

    @Column(nullable = true, name = "inspecter")
    private String giamDinhVien;

    @Column(nullable = true, name = "inspecter_phone")
    private String sdtGiamDinhVien;

    @Column(nullable = true, name = "operator_id")
    private String idTongDaiVien;

    @Column(nullable = true, name = "owner_phone")
    private String sdtChuXe;

    @Column(nullable = true, name = "note")
    private String ghiChu;

    @Column(nullable = true, name = "repair_address")
    private String diaChiSuaChua;

    @Column(nullable = true, name = "email_GR/SR")
    private String emailGRSR;

    @Column(nullable = true, name = "email_24/7")
    private String email247;

    @Column(nullable = true, name = "passMail_24/7")
    private String passMail247;

    @Column(nullable = true, name = "date_MIC")
     private String ngayMICHoSo;

    @Column(nullable = true, name = "content")
    private String noiDung;

    @Column(nullable = true, name = "email_handle")
    private String emailCanBoXuLy;

    @Column(nullable = true, name = "email_content")
    private String noiDungEmail;

    @Column(nullable = true, name = "operator_handling")
    private String tongDaiVienXuLy;

    @Column(nullable = true, name = "handle_status")
    private String trangThaiXuLy;

    @Column(nullable = true, name = "contacter")
    private String nguoiLienHe;

    @Column(nullable = true, name = "address")
    private String diaChi;

    @Column(nullable = true, name = "question_content")
    private String noiDungCauHoi;

    @Column(nullable = true, name = "exchange_content")
    private String noiDungTraoDoi;

    @Column(nullable = true, name = "type_choice")
    private String loaiLuaChon;

    @Column(nullable = true, name = "detail_cause")
    private String nguyenNhanChiTiet;

    @Column(nullable = true, name = "is_duplicate_location_assessment")
    private Boolean isGiamDinhTrungDiaDiem = false;

    @Column(nullable = true, name = "locate_recommend")
    private String diaDiemDeNghi;
}

