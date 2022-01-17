package com.milestone1OLD;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
 
public class filetodb {
	 
	    public static void main(String[] args) {
	    	ArrayList<invoice_pojo> data = new ArrayList<invoice_pojo>();
	        String jdbcURL = "jdbc:mysql://localhost:3306/invoice_details";
	        String username = "root";
	        String password = "root";
	 
	        String file = "C:/Users/KIIT/Downloads/Summer_Internship_Backend/Summer_Internship_Backend.csv";
	 
	        int batchSize = 100;
	 
	        Connection connection = null;
	 
	        try {
	 
	            connection = DriverManager.getConnection(jdbcURL, username, password);
	            connection.setAutoCommit(false);
	 
	            String sql = "INSERT INTO review (business_code, cust_number, name_customer, clear_date, business_year, doc_id, posting_date, document_create_date, document_create_date_1, due_in_date, invoice_currency, document_type, posting_id, area_business, total_open_amount, baseline_create_date, cust_payment_terms, invoice_id, isOpen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sql);
	 
	            BufferedReader lineReader = new BufferedReader(new FileReader(file));
	            String lineText = null;
	 
	            int count = 0;
	            invoice_pojo invoice = new invoice_pojo();
	            lineReader.readLine(); // skip header line
	 
	            while ((lineText = lineReader.readLine()) != null) {
	                count++;
	                String[] data1 = lineText.split(",");
					invoice.setBusiness_code(data1[0]);
					invoice.setCust_number(data1[1]);
					invoice.setName_customer(data1[2]);
					DateFormat format = new SimpleDateFormat("MMMM-dd-yyyy", Locale.ENGLISH);
					Date date;
					try {
							date = format.parse(data1[3]);
							invoice.setClear_date(date);
						}catch (ParseException e) {
							e.printStackTrace();
						}
					
					invoice.setBusiness_year(Integer.parseInt(data1[4].trim()));
					invoice.setDoc_id(Integer.parseInt(data1[5]));
					try {
						date = format.parse(data1[6]);
						invoice.setPosting_date(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					try {
						date = format.parse(data1[7]);
						invoice.setDocument_create_date(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					try {
						date = format.parse(data1[8]);
						invoice.setDocument_create_date_1(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					DateFormat format1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
					Date date1 ;
				    try {
						date1 = format1.parse(data1[9]);
						invoice.setDue_in_date(date1);
				    } catch (ParseException e) {
						e.printStackTrace();
					}
				    invoice.setInvoice_currency(data1[10]);
				    invoice.setDocument_type(data1[11]);
				    invoice.setPosting_id(Integer.parseInt(data1[12].trim()));
				    invoice.setArea_business(data1[13]);
				    invoice.setTotal_open_amount(Double.valueOf(data1[14]));
				    try {
						date1 = format1.parse(data1[15]);
						invoice.setBaseline_create_date(date1);
				    } catch (ParseException e) {
						e.printStackTrace();
					}
				    invoice.setCust_payment_terms(data1[16]);
				    invoice.setInvoice_id(Integer.parseInt(data1[17].trim()));
				    invoice.setIsOpen(Integer.parseInt(data1[18]));
					data.add(invoice);
					 statement.setString(1, invoice.getBusiness_code());
		                statement.setString(2, invoice.getCust_number());
		                statement.setString(3, invoice.getName_customer());         
		                statement.setDate(4, (java.sql.Date) invoice.getClear_date());
		                statement.setInt(5, invoice.getBusiness_year());
		                statement.setDouble(6, invoice.getDoc_id());
		                statement.setDate(7, (java.sql.Date) invoice.getPosting_date());
		                statement.setDate(8, (java.sql.Date) invoice.getDocument_create_date());
		                statement.setDate(9, (java.sql.Date) invoice.getDocument_create_date_1());
		                statement.setDate(10, (java.sql.Date) invoice.getDue_in_date());   
		                statement.setString(11, invoice.getInvoice_currency());
		                statement.setString(12, invoice.getDocument_type());
		                statement.setInt(13, invoice.getPosting_id());
		                statement.setString(14, invoice.getArea_business());
		                statement.setDouble(15, invoice.getTotal_open_amount());
		                statement.setDate(16, (java.sql.Date) invoice.getBaseline_create_date());
		                statement.setString(17, invoice.getCust_payment_terms());
		                statement.setInt(18, invoice.getInvoice_id());
		                statement.setInt(19, invoice.getIsOpen());
		                
		              
		 
		                statement.addBatch();
		 
		                if (count % batchSize == 0) {
		                    statement.executeBatch();
		                }
		            }
		 
		            // execute the remaining queries
		            statement.executeBatch();
		            lineReader.close();
	                
		       	 
		            connection.commit();
		            connection.close();
					
	            
	 
	        }catch (IOException ex) {
	            System.err.println(ex);
	        }catch (SQLException ex) {
	            ex.printStackTrace();
	 
	            try {
	                connection.rollback();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	 
	    }
	}
