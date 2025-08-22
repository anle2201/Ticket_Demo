package com.example.pro6.Service;

import com.example.pro6.DTO.request.TicketMessageRequest;
import com.example.pro6.DTO.response.TicketMessageResponse;
import com.example.pro6.Model.TicketMessage;
import com.example.pro6.Repository.TicketMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pro6.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TicketMessageImp implements TicketMessageService {

    @Autowired
    private TicketMessageRepository messageRepository;

    @Autowired
    private TicketRepository ticketRepository;


    public Long create(TicketMessageRequest.CreatTicketMessage ticketMessageRequest) {
        try {
            TicketMessage newticketMessage = new TicketMessage();
            newticketMessage.setTicketId(ticketMessageRequest.getTicketId());
            newticketMessage.setBienSoXe(ticketMessageRequest.getBienSoXe());
            newticketMessage.setNgayHL(ticketMessageRequest.getNgayHL());
            newticketMessage.setNgayHetHL(ticketMessageRequest.getNgayHetHL());
            newticketMessage.setNghiepVu(ticketMessageRequest.getNghiepVu());
            newticketMessage.setSoGCN(ticketMessageRequest.getSoGCN());
            newticketMessage.setTenKH(ticketMessageRequest.getTenKH());
            newticketMessage.setSdt(ticketMessageRequest.getSdt());
            newticketMessage.setSoKhung(ticketMessageRequest.getSoKhung());
            newticketMessage.setTenNguoiThongBao(ticketMessageRequest.getTenNguoiThongBao());
            newticketMessage.setSdtNguoiThongBao(ticketMessageRequest.getSdtNguoiThongBao());
            newticketMessage.setSdtLienHe(ticketMessageRequest.getSdtLienHe());
            newticketMessage.setSoGCNBaoHiem(ticketMessageRequest.getSoGCNBaoHiem());
            newticketMessage.setNguoiThongBao(ticketMessageRequest.getNguoiThongBao());
            newticketMessage.setLoaiHinh(ticketMessageRequest.getLoaiHinh());
            newticketMessage.setLoaiHinhNghiepVu(ticketMessageRequest.getLoaiHinhNghiepVu());
            newticketMessage.setHienTruong(ticketMessageRequest.getHienTruong());
            newticketMessage.setNgayTonThat(ticketMessageRequest.getNgayTonThat());
            newticketMessage.setGioTonThat(ticketMessageRequest.getGioTonThat());
            newticketMessage.setDiaDiemTonThat(ticketMessageRequest.getDiaDiemTonThat());
            newticketMessage.setMoTaTonThat(ticketMessageRequest.getMoTaTonThat());
            newticketMessage.setLaiXe(ticketMessageRequest.getLaiXe());
            newticketMessage.setTinhThanh(ticketMessageRequest.getTinhThanh());
            newticketMessage.setPhuongXa(ticketMessageRequest.getPhuongXa());
            newticketMessage.setHauQua(ticketMessageRequest.getHauQua());
            newticketMessage.setNhomNguyenNhan(ticketMessageRequest.getNhomNguyenNhan());
            newticketMessage.setHauQuaBenThuBa(ticketMessageRequest.getHauQuaBenThuBa());
            newticketMessage.setDiaDiemGiamDinh(ticketMessageRequest.getDiaDiemGiamDinh());
            newticketMessage.setGiamDinhVien(ticketMessageRequest.getGiamDinhVien());
            newticketMessage.setSdtGiamDinhVien(ticketMessageRequest.getSdtGiamDinhVien());
            newticketMessage.setIdTongDaiVien(ticketMessageRequest.getIdTongDaiVien());
            newticketMessage.setSdtChuXe(ticketMessageRequest.getSdtChuXe());
            newticketMessage.setGhiChu(ticketMessageRequest.getGhiChu());
            newticketMessage.setDiaChiSuaChua(ticketMessageRequest.getDiaChiSuaChua());
            newticketMessage.setEmailGRSR(ticketMessageRequest.getEmailGRSR());
            newticketMessage.setEmail247(ticketMessageRequest.getEmail247());
            newticketMessage.setPassMail247(ticketMessageRequest.getPassMail247());
            newticketMessage.setEmail(ticketMessageRequest.getEmail());
            newticketMessage.setDonViCap(ticketMessageRequest.getDonViCap());
            newticketMessage.setNgayMICHoSo(ticketMessageRequest.getNgayMICHoSo());
            newticketMessage.setDiaChi(ticketMessageRequest.getDiaChi());
            newticketMessage.setNoiDung(ticketMessageRequest.getNoiDung());
            newticketMessage.setEmailCanBoXuLy(ticketMessageRequest.getEmailCanBoXuLy());
            newticketMessage.setNoiDungEmail(ticketMessageRequest.getNoiDungEmail());
            newticketMessage.setTongDaiVienXuLy(ticketMessageRequest.getTongDaiVienXuLy());
            newticketMessage.setTrangThaiXuLy(ticketMessageRequest.getTrangThaiXuLy());
            newticketMessage.setNguoiLienHe(ticketMessageRequest.getNguoiLienHe());
            newticketMessage.setNoiDungCauHoi(ticketMessageRequest.getNoiDungCauHoi());
            newticketMessage.setNoiDungTraoDoi(ticketMessageRequest.getNoiDungTraoDoi());
            newticketMessage.setLoaiLuaChon(ticketMessageRequest.getLoaiLuaChon());
            newticketMessage.setNguyenNhanChiTiet(ticketMessageRequest.getNguyenNhanChiTiet());
            newticketMessage.setDiaDiemDeNghi(ticketMessageRequest.getDiaDiemDeNghi());
            newticketMessage.setIsGiamDinhTrungDiaDiem(ticketMessageRequest.getIsGiamDinhTrungDiaDiem());
            TicketMessage newTicketMessage = messageRepository.save(newticketMessage);
            return newTicketMessage.getId();
        } catch (Exception e) {
            System.out.println("Error create ticket message: " + e.getMessage());
            return -1L;
        }
    }

    public List<TicketMessageResponse.Detail> getAll(String status, String priority, String giveTo, String typeAccident, String CCs) {

        List<TicketMessage> ticketMessages = messageRepository.searchAll(status, priority, giveTo, typeAccident, CCs);
        List<TicketMessageResponse.Detail> result = new ArrayList<>();
        for (TicketMessage ticketMessage : ticketMessages) {
            TicketMessageResponse.Detail response = new TicketMessageResponse.Detail();

            response.setId(ticketMessage.getId());
            response.setTicketId(ticketMessage.getTicketId());
            response.setBienSoXe(ticketMessage.getBienSoXe());
            response.setNgayHL(ticketMessage.getNgayHL());
            response.setSoGCN(ticketMessage.getSoGCN());
            response.setTenKH(ticketMessage.getTenKH());
            response.setSdt(ticketMessage.getSdt());
            response.setSoKhung(ticketMessage.getSoKhung());

            result.add(response);
        }
        return result;
    }


    public boolean checkExistTicketId(Long ticketId) {
        return ticketRepository.existsById(ticketId);
    }

    public boolean checkExistTicketMessage(Long ticketMessageId) {
        return messageRepository.existsById(ticketMessageId);
    }

    public Optional<TicketMessage> getMessagesByTicketId(Long ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            System.out.println("Không tồn tại ticket với id = " + ticketId);
        }
        return messageRepository.findByTicketId(ticketId);
    }

    @Override
    public TicketMessageResponse.All getDetail(Long id) {
        Optional<TicketMessage> optionalTicketMessage = messageRepository.findById(id);
        try {
            if (optionalTicketMessage.isEmpty()) {
                System.out.println("Không tồn tại ticket message với id = " + id);
                return null;
            }

            TicketMessage ticketMessage = optionalTicketMessage.get();
            TicketMessageResponse.All detail = new TicketMessageResponse.All();
            detail.setId(ticketMessage.getId());
            detail.setTicketId(ticketMessage.getTicketId());
            detail.setBienSoXe(ticketMessage.getBienSoXe());
            detail.setNgayHL(ticketMessage.getNgayHL());
            detail.setNgayHetHL(ticketMessage.getNgayHetHL());
            detail.setNghiepVu(ticketMessage.getNghiepVu());
            detail.setSoGCN(ticketMessage.getSoGCN());
            detail.setTenKH(ticketMessage.getTenKH());
            detail.setSdt(ticketMessage.getSdt());
            detail.setSoKhung(ticketMessage.getSoKhung());
            detail.setTenNguoiThongBao(ticketMessage.getTenNguoiThongBao());
            detail.setSdtNguoiThongBao(ticketMessage.getSdtNguoiThongBao());
            detail.setSdtLienHe(ticketMessage.getSdtLienHe());
            detail.setSoGCNBaoHiem(ticketMessage.getSoGCNBaoHiem());
            detail.setNguoiThongBao(ticketMessage.getNguoiThongBao());
            detail.setLoaiHinh(ticketMessage.getLoaiHinh());
            detail.setLoaiHinhNghiepVu(ticketMessage.getLoaiHinhNghiepVu());
            detail.setHienTruong(ticketMessage.getHienTruong());
            detail.setNgayTonThat(ticketMessage.getNgayTonThat());
            detail.setGioTonThat(ticketMessage.getGioTonThat());
            detail.setDiaDiemTonThat(ticketMessage.getDiaDiemTonThat());
            detail.setMoTaTonThat(ticketMessage.getMoTaTonThat());
            detail.setLaiXe(ticketMessage.getLaiXe());
            detail.setTinhThanh(ticketMessage.getTinhThanh());
            detail.setPhuongXa(ticketMessage.getPhuongXa());
            detail.setHauQua(ticketMessage.getHauQua());
            detail.setNhomNguyenNhan(ticketMessage.getNhomNguyenNhan());
            detail.setHauQuaBenThuBa(ticketMessage.getHauQuaBenThuBa());
            detail.setDiaDiemGiamDinh(ticketMessage.getDiaDiemGiamDinh());
            detail.setGiamDinhVien(ticketMessage.getGiamDinhVien());
            detail.setSdtGiamDinhVien(ticketMessage.getSdtGiamDinhVien());
            detail.setIdTongDaiVien(ticketMessage.getIdTongDaiVien());
            detail.setSdtChuXe(ticketMessage.getSdtChuXe());
            detail.setGhiChu(ticketMessage.getGhiChu());
            detail.setDiaChiSuaChua(ticketMessage.getDiaChiSuaChua());
            detail.setEmailGRSR(ticketMessage.getEmailGRSR());
            detail.setEmail247(ticketMessage.getEmail247());
            detail.setPassMail247(ticketMessage.getPassMail247());
            detail.setEmail(ticketMessage.getEmail());
            detail.setDonViCap(ticketMessage.getDonViCap());
            detail.setNgayMICHoSo(ticketMessage.getNgayMICHoSo());
            detail.setDiaChi(ticketMessage.getDiaChi());
            detail.setNoiDung(ticketMessage.getNoiDung());
            detail.setEmailCanBoXuLy(ticketMessage.getEmailCanBoXuLy());
            detail.setNoiDungEmail(ticketMessage.getNoiDungEmail());
            detail.setTongDaiVienXuLy(ticketMessage.getTongDaiVienXuLy());
            detail.setTrangThaiXuLy(ticketMessage.getTrangThaiXuLy());
            detail.setNguoiLienHe(ticketMessage.getNguoiLienHe());
            detail.setNoiDungCauHoi(ticketMessage.getNoiDungCauHoi());
            detail.setNoiDungTraoDoi(ticketMessage.getNoiDungTraoDoi());
            detail.setLoaiLuaChon(ticketMessage.getLoaiLuaChon());
            detail.setDiaDiemDeNghi(ticketMessage.getDiaDiemDeNghi());
            detail.setNguyenNhanChiTiet(ticketMessage.getNguyenNhanChiTiet());
            detail.setIsGiamDinhTrungDiaDiem(ticketMessage.getIsGiamDinhTrungDiaDiem());

            return detail;
        } catch (Exception e) {
            System.out.println("Error retrieving ticket message: " + e.getMessage());
            return null;
        }
    }

    public TicketMessage update(TicketMessage updatedData) {
        Long id = updatedData.getId();
        Optional<TicketMessage> optional = messageRepository.findById(id);
        if (optional.isEmpty()) return null;
        TicketMessage existing = optional.get();

        existing.setSoGCN(updatedData.getSoGCN());
        existing.setNghiepVu(updatedData.getNghiepVu());
        existing.setSdt(updatedData.getSdt());
        existing.setTenKH(updatedData.getTenKH());
        existing.setNgayHL(updatedData.getNgayHL());
        existing.setNgayHetHL(updatedData.getNgayHetHL());
        existing.setBienSoXe(updatedData.getBienSoXe());
        existing.setSoKhung(updatedData.getSoKhung());
        existing.setTicketId(updatedData.getTicketId());
        existing.setTenNguoiThongBao(updatedData.getTenNguoiThongBao());
        existing.setSdtNguoiThongBao(updatedData.getSdtNguoiThongBao());
        existing.setSdtLienHe(updatedData.getSdtLienHe());
        existing.setSoGCNBaoHiem(updatedData.getSoGCNBaoHiem());
        existing.setNguoiThongBao(updatedData.getNguoiThongBao());
        existing.setLoaiHinh(updatedData.getLoaiHinh());
        existing.setLoaiHinhNghiepVu(updatedData.getLoaiHinhNghiepVu());
        existing.setHienTruong(updatedData.getHienTruong());
        existing.setNgayTonThat(updatedData.getNgayTonThat());
        existing.setGioTonThat(updatedData.getGioTonThat());
        existing.setDiaDiemTonThat(updatedData.getDiaDiemTonThat());
        existing.setMoTaTonThat(updatedData.getMoTaTonThat());
        existing.setLaiXe(updatedData.getLaiXe());
        existing.setTinhThanh(updatedData.getTinhThanh());
        existing.setPhuongXa(updatedData.getPhuongXa());
        existing.setHauQua(updatedData.getHauQua());
        existing.setNhomNguyenNhan(updatedData.getNhomNguyenNhan());
        existing.setHauQuaBenThuBa(updatedData.getHauQuaBenThuBa());
        existing.setDiaDiemGiamDinh(updatedData.getDiaDiemGiamDinh());
        existing.setGiamDinhVien(updatedData.getGiamDinhVien());
        existing.setSdtGiamDinhVien(updatedData.getSdtGiamDinhVien());
        existing.setIdTongDaiVien(updatedData.getIdTongDaiVien());
        existing.setSdtChuXe(updatedData.getSdtChuXe());
        existing.setGhiChu(updatedData.getGhiChu());
        existing.setDiaChiSuaChua(updatedData.getDiaChiSuaChua());
        existing.setEmailGRSR(updatedData.getEmailGRSR());
        existing.setEmail247(updatedData.getEmail247());
        existing.setPassMail247(updatedData.getPassMail247());
        existing.setEmailCanBoXuLy(updatedData.getEmailCanBoXuLy());
        existing.setNoiDungEmail(updatedData.getNoiDungEmail());
        existing.setTongDaiVienXuLy(updatedData.getTongDaiVienXuLy());
        existing.setTrangThaiXuLy(updatedData.getTrangThaiXuLy());
        existing.setNguoiLienHe(updatedData.getNguoiLienHe());
        existing.setNoiDungCauHoi(updatedData.getNoiDungCauHoi());
        existing.setNoiDungTraoDoi(updatedData.getNoiDungTraoDoi());
        existing.setEmail(updatedData.getEmail());
        existing.setDonViCap(updatedData.getDonViCap());
        existing.setNgayMICHoSo(updatedData.getNgayMICHoSo());
        existing.setNoiDung(updatedData.getNoiDung());
        existing.setDiaChi(updatedData.getDiaChi());
        existing.setIsGiamDinhTrungDiaDiem(updatedData.getIsGiamDinhTrungDiaDiem());
        existing.setDiaDiemDeNghi(updatedData.getDiaDiemDeNghi());
        existing.setNguyenNhanChiTiet(updatedData.getNguyenNhanChiTiet());
        return messageRepository.save(existing);
    }

    public TicketMessageResponse.AccidentDetail getAccidentDetail(Long id) {
        Optional<TicketMessage> optional = messageRepository.findById(id);
        try {
            if (optional.isEmpty()) {
                System.out.println("Customer not found with id: " + id);
                return null;
            }

            TicketMessage ticketMessage = optional.get();
            TicketMessageResponse.AccidentDetail accidentDetail = new TicketMessageResponse.AccidentDetail();
            accidentDetail.setNghiepVu(ticketMessage.getNghiepVu());
            accidentDetail.setLoaiHinh(ticketMessage.getLoaiHinh());
            accidentDetail.setLoaiHinhNghiepVu(ticketMessage.getLoaiHinhNghiepVu());
            accidentDetail.setHienTruong(ticketMessage.getHienTruong());
            accidentDetail.setBienSoXe(ticketMessage.getBienSoXe());
            accidentDetail.setSoGCNBaoHiem(ticketMessage.getSoGCNBaoHiem());
            accidentDetail.setNguoiThongBao(ticketMessage.getNguoiThongBao());
            accidentDetail.setTenNguoiThongBao(ticketMessage.getTenNguoiThongBao());
            accidentDetail.setSdtNguoiThongBao(ticketMessage.getSdtNguoiThongBao());
            accidentDetail.setSdtLienHe(ticketMessage.getSdtLienHe());
            accidentDetail.setNgayTonThat(ticketMessage.getNgayTonThat());
            accidentDetail.setGioTonThat(ticketMessage.getGioTonThat());
            accidentDetail.setLaiXe(ticketMessage.getLaiXe());
            accidentDetail.setTinhThanh(ticketMessage.getTinhThanh());
            accidentDetail.setPhuongXa(ticketMessage.getPhuongXa());
            accidentDetail.setDiaDiemTonThat(ticketMessage.getDiaDiemTonThat());
            accidentDetail.setHauQua(ticketMessage.getHauQua());
            accidentDetail.setMoTaTonThat(ticketMessage.getMoTaTonThat());
            accidentDetail.setNhomNguyenNhan(ticketMessage.getNhomNguyenNhan());
            accidentDetail.setHauQuaBenThuBa(ticketMessage.getHauQuaBenThuBa());
            accidentDetail.setDiaDiemGiamDinh(ticketMessage.getDiaDiemGiamDinh());
            accidentDetail.setGiamDinhVien(ticketMessage.getGiamDinhVien());
            accidentDetail.setSdtGiamDinhVien(ticketMessage.getSdtGiamDinhVien());
            accidentDetail.setIdTongDaiVien(ticketMessage.getIdTongDaiVien());
            accidentDetail.setSdtChuXe(ticketMessage.getSdtChuXe());
            accidentDetail.setGhiChu(ticketMessage.getGhiChu());
            accidentDetail.setDiaChiSuaChua(ticketMessage.getDiaChiSuaChua());
            accidentDetail.setEmailGRSR(ticketMessage.getEmailGRSR());
            accidentDetail.setEmail247(ticketMessage.getEmail247());
            accidentDetail.setPassMail247(ticketMessage.getPassMail247());
            accidentDetail.setIsGiamDinhTrungDiaDiem(ticketMessage.getIsGiamDinhTrungDiaDiem());
            accidentDetail.setNguyenNhanChiTiet(ticketMessage.getNguyenNhanChiTiet());
            accidentDetail.setDiaDiemDeNghi(ticketMessage.getDiaDiemDeNghi());

            return accidentDetail;


        } catch (Exception e) {
            System.out.println("Error retrieving accident detail: " + e.getMessage());
            return null;
        }

    }

    public Long createCustomer(TicketMessageRequest.CreatCustomer customerRequest) {
        try {
            TicketMessage newCustomer = new TicketMessage();
            newCustomer.setTicketId(customerRequest.getTicketId());
            newCustomer.setTenKH(customerRequest.getTenKH());
            newCustomer.setSdt(customerRequest.getSdt());
            newCustomer.setEmail(customerRequest.getEmail());
            newCustomer.setBienSoXe(customerRequest.getBienSoXe());
            newCustomer.setDonViCap(customerRequest.getDonViCap());
            newCustomer.setNgayHL(customerRequest.getNgayHL());
            newCustomer.setNgayHetHL(customerRequest.getNgayHetHL());
            newCustomer.setLoaiLuaChon("Khách hàng");
            TicketMessage newCustomerMessage = messageRepository.save(newCustomer);
            return newCustomerMessage.getId();
        } catch (Exception e) {
            System.out.println("Error creat customer message");
            return -1L;
        }
    }

    public TicketMessageResponse.CustomerDetail getCustomerDetail(Long id) {
        Optional<TicketMessage> optional = messageRepository.findById(id);
        try {
            if (optional.isEmpty()) {
                System.out.println("Customer not found with id: " + id);
                return null;
            }
            TicketMessage ticketMessage = optional.get();
            TicketMessageResponse.CustomerDetail customerDetail = new TicketMessageResponse.CustomerDetail();
            customerDetail.setTenKH(ticketMessage.getTenKH());
            customerDetail.setSdt(ticketMessage.getSdt());
            customerDetail.setEmail(ticketMessage.getEmail());
            customerDetail.setBienSoXe(ticketMessage.getBienSoXe());
            customerDetail.setDonViCap(ticketMessage.getDonViCap());
            customerDetail.setNgayHL(ticketMessage.getNgayHL());
            customerDetail.setNgayHetHL(ticketMessage.getNgayHetHL());
            customerDetail.setLoaiLuaChon(ticketMessage.getLoaiLuaChon());
            return customerDetail;

        } catch (Exception e) {
            System.out.println("Error get customer detail: " + e.getMessage());
            return null;
        }
    }

    public Long createProduct(TicketMessageRequest.CreateProduct productRequest) {
        try {
            TicketMessage newProduct = new TicketMessage();
            newProduct.setTicketId(productRequest.getTicketId());
            newProduct.setNguoiLienHe(productRequest.getNguoiLienHe());
            newProduct.setDiaChi(productRequest.getDiaChi());
            newProduct.setNoiDungCauHoi(productRequest.getNoiDungCauHoi());
            newProduct.setNghiepVu(productRequest.getNghiepVu());
            newProduct.setEmailCanBoXuLy(productRequest.getEmailCanBoXuLy());
            newProduct.setNoiDungEmail(productRequest.getNoiDungEmail());
            newProduct.setTongDaiVienXuLy(productRequest.getTongDaiVienXuLy());
            newProduct.setGhiChu(productRequest.getGhiChu());
            newProduct.setLoaiLuaChon("Sản phẩm");
            TicketMessage newProductMessage = messageRepository.save(newProduct);
            return newProductMessage.getId();
        } catch (Exception e) {
            System.out.println("Error creat product message");
            return -1L;
        }
    }

    public TicketMessageResponse.ProductDetail getProductDetail(Long id) {
        Optional<TicketMessage> optional = messageRepository.findById(id);
        try {
            if (optional.isEmpty()) {
                System.out.println("Product not found with id: " + id);
                return null;
            }

            TicketMessage ticketMessage = optional.get();
            TicketMessageResponse.ProductDetail productDetail = new TicketMessageResponse.ProductDetail();
            productDetail.setNguoiLienHe(ticketMessage.getNguoiLienHe());
            productDetail.setDiaChi(ticketMessage.getDiaChi());
            productDetail.setNoiDungCauHoi(ticketMessage.getNoiDungCauHoi());
            productDetail.setNghiepVu(ticketMessage.getNghiepVu());
            productDetail.setEmailCanBoXuLy(ticketMessage.getEmailCanBoXuLy());
            productDetail.setNoiDungEmail(ticketMessage.getNoiDungEmail());
            productDetail.setTongDaiVienXuLy(ticketMessage.getTongDaiVienXuLy());
            productDetail.setGhiChu(ticketMessage.getGhiChu());
            productDetail.setLoaiLuaChon(ticketMessage.getLoaiLuaChon());
            return productDetail;

        } catch (Exception e) {
            System.out.println("Error get product detail: " + e.getMessage());
            return null;
        }
    }

    public TicketMessageResponse.ComplaintsDetail getComplaintsDetail(Long id) {
        Optional<TicketMessage> optional = messageRepository.findById(id);
        try {
            if (optional.isEmpty()) {
                System.out.println("Customer not found with id: " + id);
                return null;
            }
            TicketMessage ticketMessage = optional.get();
            TicketMessageResponse.ComplaintsDetail complaintsDetail = new TicketMessageResponse.ComplaintsDetail();
            complaintsDetail.setTenKH(ticketMessage.getTenKH());
            complaintsDetail.setSdt(ticketMessage.getSdt());
            complaintsDetail.setNghiepVu(ticketMessage.getNghiepVu());
            complaintsDetail.setNgayTonThat(ticketMessage.getNgayTonThat());
            complaintsDetail.setGioTonThat(ticketMessage.getGioTonThat());
            complaintsDetail.setNgayMICHoSo(ticketMessage.getNgayMICHoSo());
            complaintsDetail.setNoiDung(ticketMessage.getNoiDung());
            complaintsDetail.setEmailCanBoXuLy(ticketMessage.getEmailCanBoXuLy());
            complaintsDetail.setNoiDungEmail(ticketMessage.getNoiDungEmail());
            complaintsDetail.setTongDaiVienXuLy(ticketMessage.getTongDaiVienXuLy());
            complaintsDetail.setTrangThaiXuLy(ticketMessage.getTrangThaiXuLy());
            complaintsDetail.setGhiChu(ticketMessage.getGhiChu());
            complaintsDetail.setLoaiLuaChon(ticketMessage.getLoaiLuaChon());
            return complaintsDetail;

        } catch (Exception e) {
            System.out.println("Error get complaints detail: " + e.getMessage());
            return null;
        }
    }

    public Long createComplaints(TicketMessageRequest.CreateComplaints complaintsRequest) {
        try {
            TicketMessage newComplaint = new TicketMessage();
            newComplaint.setTicketId(complaintsRequest.getTicketId());
            newComplaint.setNghiepVu(complaintsRequest.getNghiepVu());
            newComplaint.setSdt(complaintsRequest.getSdt());
            newComplaint.setTenKH(complaintsRequest.getTenKH());
            newComplaint.setEmailCanBoXuLy(complaintsRequest.getEmailCanBoXuLy());
            newComplaint.setNgayMICHoSo(complaintsRequest.getNgayMICHoSo());
            newComplaint.setNoiDung(complaintsRequest.getNoiDung());
            newComplaint.setGioTonThat(complaintsRequest.getGioTonThat());
            newComplaint.setNgayTonThat(complaintsRequest.getNgayTonThat());
            newComplaint.setNoiDungEmail(complaintsRequest.getNoiDungEmail());
            newComplaint.setTongDaiVienXuLy(complaintsRequest.getTongDaiVienXuLy());
            newComplaint.setTrangThaiXuLy(complaintsRequest.getTrangThaiXuLy());
            newComplaint.setGhiChu(complaintsRequest.getGhiChu());
            newComplaint.setLoaiLuaChon("Khiếu nại");
            TicketMessage savedComplaint = messageRepository.save(newComplaint);
            return savedComplaint.getId();

        } catch (Exception e) {
            System.out.println("Error creating complaint message");
            return -1L;
        }
    }

    public TicketMessageResponse.OtherDetail getOtherDetail(Long id) {
        Optional<TicketMessage> optional = messageRepository.findById(id);
        try {
            if (optional.isEmpty()) {
                System.out.println("Other message not found with id: " + id);
                return null;
            }
            TicketMessage ticketMessage = optional.get();
            TicketMessageResponse.OtherDetail otherDetail = new TicketMessageResponse.OtherDetail();
            otherDetail.setTongDaiVienXuLy(ticketMessage.getTongDaiVienXuLy());
            otherDetail.setDiaChi(ticketMessage.getDiaChi());
            otherDetail.setNguoiLienHe(ticketMessage.getNguoiLienHe());
            otherDetail.setNoiDungTraoDoi(ticketMessage.getNoiDungTraoDoi());
            otherDetail.setGhiChu(ticketMessage.getGhiChu());
            otherDetail.setLoaiLuaChon(ticketMessage.getLoaiLuaChon());
            return otherDetail;

        } catch (Exception e) {
            System.out.println("Error get other detail: " + e.getMessage());
            return null;
        }
    }

    public Long createOther(TicketMessageRequest.CreateOther otherRequest) {
        try {
            TicketMessage newOther = new TicketMessage();
            newOther.setTicketId(otherRequest.getTicketId());
            newOther.setTongDaiVienXuLy(otherRequest.getTongDaiVienXuLy());
            newOther.setDiaChi(otherRequest.getDiaChi());
            newOther.setNguoiLienHe(otherRequest.getNguoiLienHe());
            newOther.setNoiDungTraoDoi(otherRequest.getNoiDungTraoDoi());
            newOther.setGhiChu(otherRequest.getGhiChu());
            newOther.setLoaiLuaChon("Khác");
            TicketMessage savedOther = messageRepository.save(newOther);
            return savedOther.getId();
        } catch (Exception e) {
            System.out.println("Error creating other message");
            return -1L;
        }
    }

    public Long createAccident(TicketMessageRequest.CreateAccident accidentRequest) {
        try {
            TicketMessage newAccident = new TicketMessage();
            newAccident.setTicketId(accidentRequest.getTicketId());
            newAccident.setNghiepVu(accidentRequest.getNghiepVu());
            newAccident.setSdtLienHe(accidentRequest.getSdtLienHe());
            newAccident.setBienSoXe(accidentRequest.getBienSoXe());
            newAccident.setTenNguoiThongBao(accidentRequest.getTenNguoiThongBao());
            newAccident.setSdtNguoiThongBao(accidentRequest.getSdtNguoiThongBao());
            newAccident.setSdtLienHe(accidentRequest.getSdtLienHe());
            newAccident.setSoGCNBaoHiem(accidentRequest.getSoGCNBaoHiem());
            newAccident.setNguoiThongBao(accidentRequest.getNguoiThongBao());
            newAccident.setLoaiHinh(accidentRequest.getLoaiHinh());
            newAccident.setLoaiHinhNghiepVu(accidentRequest.getLoaiHinhNghiepVu());
            newAccident.setHienTruong(accidentRequest.getHienTruong());
            newAccident.setNgayTonThat(accidentRequest.getNgayTonThat());
            newAccident.setGioTonThat(accidentRequest.getGioTonThat());
            newAccident.setDiaDiemTonThat(accidentRequest.getDiaDiemTonThat());
            newAccident.setMoTaTonThat(accidentRequest.getMoTaTonThat());
            newAccident.setLaiXe(accidentRequest.getLaiXe());
            newAccident.setTinhThanh(accidentRequest.getTinhThanh());
            newAccident.setPhuongXa(accidentRequest.getPhuongXa());
            newAccident.setHauQua(accidentRequest.getHauQua());
            newAccident.setNhomNguyenNhan(accidentRequest.getNhomNguyenNhan());
            newAccident.setHauQuaBenThuBa(accidentRequest.getHauQuaBenThuBa());
            newAccident.setTenNguoiThongBao(accidentRequest.getTenNguoiThongBao());
            newAccident.setDiaDiemGiamDinh(accidentRequest.getDiaDiemGiamDinh());
            newAccident.setGiamDinhVien(accidentRequest.getGiamDinhVien());
            newAccident.setSdtGiamDinhVien(accidentRequest.getSdtGiamDinhVien());
            newAccident.setIdTongDaiVien(accidentRequest.getIdTongDaiVien());
            newAccident.setSdtChuXe(accidentRequest.getSdtChuXe());
            newAccident.setGhiChu(accidentRequest.getGhiChu());
            newAccident.setDiaChiSuaChua(accidentRequest.getDiaChiSuaChua());
            newAccident.setEmailGRSR(accidentRequest.getEmailGRSR());
            newAccident.setEmail247(accidentRequest.getEmail247());
            newAccident.setPassMail247(accidentRequest.getPassMail247());
            newAccident.setIsGiamDinhTrungDiaDiem(accidentRequest.getIsGiamDinhTrungDiaDiem());
            newAccident.setDiaDiemDeNghi(accidentRequest.getDiaDiemDeNghi());
            newAccident.setNguyenNhanChiTiet(accidentRequest.getNguyenNhanChiTiet());
            newAccident.setLoaiLuaChon("Tổn thất");
            TicketMessage newAccidentMessage = messageRepository.save(newAccident);
            return newAccidentMessage.getId();

        } catch (Exception e) {
            System.out.println("Error creating accident message: " + e.getMessage());
            return -1L;
        }
    }

    public TicketMessage delete(Long id) {
        try {
            Optional<TicketMessage> optional = messageRepository.findById(id);
            if (optional.isEmpty())
                return null;
            TicketMessage existing = optional.get();
            messageRepository.delete(existing);
            return existing;
        } catch (Exception e) {
            System.out.println("Error deleting ticket message: " + e.getMessage());
            return null;
        }
    }

    public TicketMessageRequest.CreatCustomer updateCustomer(TicketMessageRequest.CreatCustomer customerRequest) {
        try {
            TicketMessage ticketMessage = messageRepository.findByTicketId(customerRequest.getTicketId())
                    .orElseThrow(() -> new RuntimeException("Ticket message not found"));
            ticketMessage.setTicketId(customerRequest.getTicketId());
            ticketMessage.setTenKH(customerRequest.getTenKH());
            ticketMessage.setSdt(customerRequest.getSdt());
            ticketMessage.setEmail(customerRequest.getEmail());
            ticketMessage.setBienSoXe(customerRequest.getBienSoXe());
            ticketMessage.setDonViCap(customerRequest.getDonViCap());
            ticketMessage.setNgayHL(customerRequest.getNgayHL());
            ticketMessage.setNgayHetHL(customerRequest.getNgayHetHL());

            messageRepository.save(ticketMessage);
            return customerRequest;
        } catch (Exception e) {
            System.out.println("Error updating customer message: " + e.getMessage());
            return null;
        }

    }

    public TicketMessageRequest.CreateAccident updateAccident(TicketMessageRequest.CreateAccident accidentRequest) {
        try {
            TicketMessage ticketMessage = messageRepository.findByTicketId(accidentRequest.getTicketId())
                    .orElseThrow(() -> new RuntimeException("Ticket message not found"));
            ticketMessage.setTicketId(accidentRequest.getTicketId());
            ticketMessage.setNghiepVu(accidentRequest.getNghiepVu());
            ticketMessage.setSdtLienHe(accidentRequest.getSdtLienHe());
            ticketMessage.setBienSoXe(accidentRequest.getBienSoXe());
            ticketMessage.setTenNguoiThongBao(accidentRequest.getTenNguoiThongBao());
            ticketMessage.setSdtNguoiThongBao(accidentRequest.getSdtNguoiThongBao());
            ticketMessage.setSoGCNBaoHiem(accidentRequest.getSoGCNBaoHiem());
            ticketMessage.setNguoiThongBao(accidentRequest.getNguoiThongBao());
            ticketMessage.setLoaiHinh(accidentRequest.getLoaiHinh());
            ticketMessage.setLoaiHinhNghiepVu(accidentRequest.getLoaiHinhNghiepVu());
            ticketMessage.setHienTruong(accidentRequest.getHienTruong());
            ticketMessage.setNgayTonThat(accidentRequest.getNgayTonThat());
            ticketMessage.setGioTonThat(accidentRequest.getGioTonThat());
            ticketMessage.setDiaDiemTonThat(accidentRequest.getDiaDiemTonThat());
            ticketMessage.setMoTaTonThat(accidentRequest.getMoTaTonThat());
            ticketMessage.setLaiXe(accidentRequest.getLaiXe());
            ticketMessage.setTinhThanh(accidentRequest.getTinhThanh());
            ticketMessage.setPhuongXa(accidentRequest.getPhuongXa());
            ticketMessage.setHauQua(accidentRequest.getHauQua());
            ticketMessage.setNhomNguyenNhan(accidentRequest.getNhomNguyenNhan());
            ticketMessage.setHauQuaBenThuBa(accidentRequest.getHauQuaBenThuBa());
            ticketMessage.setTenNguoiThongBao(accidentRequest.getTenNguoiThongBao());
            ticketMessage.setDiaDiemGiamDinh(accidentRequest.getDiaDiemGiamDinh());
            ticketMessage.setGiamDinhVien(accidentRequest.getGiamDinhVien());
            ticketMessage.setSdtGiamDinhVien(accidentRequest.getSdtGiamDinhVien());
            ticketMessage.setIdTongDaiVien(accidentRequest.getIdTongDaiVien());
            ticketMessage.setSdtChuXe(accidentRequest.getSdtChuXe());
            ticketMessage.setGhiChu(accidentRequest.getGhiChu());
            ticketMessage.setDiaChiSuaChua(accidentRequest.getDiaChiSuaChua());
            ticketMessage.setEmailGRSR(accidentRequest.getEmailGRSR());
            ticketMessage.setEmail247(accidentRequest.getEmail247());
            ticketMessage.setPassMail247(accidentRequest.getPassMail247());
            ticketMessage.setIsGiamDinhTrungDiaDiem(accidentRequest.getIsGiamDinhTrungDiaDiem());
            ticketMessage.setDiaDiemDeNghi(accidentRequest.getDiaDiemDeNghi());
            ticketMessage.setNguyenNhanChiTiet(accidentRequest.getNguyenNhanChiTiet());
            messageRepository.save(ticketMessage);
            return accidentRequest;
        } catch (Exception e) {
            System.out.println("Error updating accident message: " + e.getMessage());
            return null;
        }
    }

        public TicketMessageRequest.CreateComplaints updateComplaints(TicketMessageRequest.CreateComplaints complaintsRequest) {
            try{
                TicketMessage ticketMessage = messageRepository.findByTicketId(complaintsRequest.getTicketId())
                        .orElseThrow(() -> new RuntimeException("Ticket message not found"));
                ticketMessage.setTicketId(complaintsRequest.getTicketId());
                ticketMessage.setTenKH(complaintsRequest.getTenKH());
                ticketMessage.setSdt(complaintsRequest.getSdt());
                ticketMessage.setNghiepVu(complaintsRequest.getNghiepVu());
                ticketMessage.setNgayTonThat(complaintsRequest.getNgayTonThat());
                ticketMessage.setGioTonThat(complaintsRequest.getGioTonThat());
                ticketMessage.setNgayMICHoSo(complaintsRequest.getNgayMICHoSo());
                ticketMessage.setNoiDung(complaintsRequest.getNoiDung());
                ticketMessage.setEmailCanBoXuLy(complaintsRequest.getEmailCanBoXuLy());
                ticketMessage.setNoiDungEmail(complaintsRequest.getNoiDungEmail());
                ticketMessage.setTongDaiVienXuLy(complaintsRequest.getTongDaiVienXuLy());
                ticketMessage.setTrangThaiXuLy(complaintsRequest.getTrangThaiXuLy());
                ticketMessage.setGhiChu(complaintsRequest.getGhiChu());
                messageRepository.save(ticketMessage);
                return complaintsRequest;
            }   catch (Exception e) {
                System.out.println("Error updating complaints message: " + e.getMessage());
                return null;
            }
        }
    public TicketMessageRequest.CreateProduct updateProduct(TicketMessageRequest.CreateProduct productRequest){
        try{
            TicketMessage ticketMessage = messageRepository.findByTicketId(productRequest.getTicketId())
                    .orElseThrow(() -> new RuntimeException("Ticket message not found"));
            ticketMessage.setTicketId(productRequest.getTicketId());
            ticketMessage.setNguoiLienHe(productRequest.getNguoiLienHe());
            ticketMessage.setDiaChi(productRequest.getDiaChi());
            ticketMessage.setNoiDungCauHoi(productRequest.getNoiDungCauHoi());
            ticketMessage.setNghiepVu(productRequest.getNghiepVu());
            ticketMessage.setEmailCanBoXuLy(productRequest.getEmailCanBoXuLy());
            ticketMessage.setNoiDungEmail(productRequest.getNoiDungEmail());
            ticketMessage.setTongDaiVienXuLy(productRequest.getTongDaiVienXuLy());
            ticketMessage.setGhiChu(productRequest.getGhiChu());
            messageRepository.save(ticketMessage);
            return productRequest;
        } catch (Exception e) {
            System.out.println("Error updating product message: " + e.getMessage());
            return null;
        }
    }

    public TicketMessageRequest.CreateOther updateOther(TicketMessageRequest.CreateOther otherRequest) {
        try {
            TicketMessage ticketMessage = messageRepository.findByTicketId(otherRequest.getTicketId())
                    .orElseThrow(() -> new RuntimeException("Ticket message not found"));
            ticketMessage.setTicketId(otherRequest.getTicketId());
            ticketMessage.setNguoiLienHe(otherRequest.getNguoiLienHe());
            ticketMessage.setNguoiLienHe(otherRequest.getNguoiLienHe());
            ticketMessage.setDiaChi(otherRequest.getDiaChi());
            ticketMessage.setTongDaiVienXuLy(otherRequest.getTongDaiVienXuLy());
            ticketMessage.setGhiChu(otherRequest.getGhiChu());
            messageRepository.save(ticketMessage);
            return otherRequest;
        } catch (Exception e) {
            System.out.println("Error updating other message: " + e.getMessage());
            return null;
        }


    }
}




