package com.myshop;
/*
    프론트 엔드 & 객체 조립
 */
import com.myshop.dao.ProductDAO;
import com.myshop.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n  [상점 시스템]");
            System.out.println("1. 상품 등록 (구매)");
            System.out.println("2. 상품 목록 보기");
            System.out.println("3. 상품 가격 수정");
            System.out.println("4. 판매 종료 (삭제)");
            System.out.println("5. 종료");
            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 줄바꿈

            switch (menu) {
                case 1:
                    System.out.println("[상품 등록] (0: 뒤로가기)");
                    System.out.print("상품 이름: ");
                    String name = sc.nextLine();
                    if (name.equals("0")) break;

                    System.out.print("가격: ");
                    int price = sc.nextInt();
                    if (price == 0) break;

                    System.out.print("판매자 ID: ");
                    int sellerId = sc.nextInt();
                    if (sellerId == 0) break;

                    Product newProduct = new Product(0, name, price, sellerId, false);
                    dao.buy(newProduct);
                    break;

                case 2:
                    System.out.println("[상품 목록] (0: 뒤로가기)");
                    List<Product> list = dao.findAll();
                    if (list.isEmpty()) {
                        System.out.println("등록된 상품이 없습니다.");
                    } else {
                        for (Product p : list) {
                            System.out.printf("ID:%d | 이름:%s | 가격:%d | 판매자:%d | 상태:%s\n",
                                    p.getId(), p.getName(), p.getPrice(), p.getSellId(),
                                    p.sold() ? "판매완료" : "판매중");
                        }
                    }
                    break;

                case 3:
                    System.out.println("[가격 수정] (0: 뒤로가기)");
                    System.out.print("수정할 상품 ID: ");
                    int upId = sc.nextInt();
                    if (upId == 0) break;

                    System.out.print("새 가격: ");
                    int newPrice = sc.nextInt();
                    if (newPrice == 0) break;

                    Product updateProduct = new Product(upId, null, newPrice, 0, false);
                    dao.update(updateProduct);
                    break;

                case 4:
                    System.out.println("[판매 종료] (0: 뒤로가기)");
                    System.out.print("판매 종료할 상품 ID: ");
                    int delId = sc.nextInt();
                    if (delId == 0) break;

                    dao.sell(delId);
                    break;

                case 5:
                    dao.exit();
                    return;

                default:
                    System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
            }
        }
    }
}
