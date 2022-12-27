package com.masai.servies.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.masai.servies.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		return null;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		return null;
	}

}
