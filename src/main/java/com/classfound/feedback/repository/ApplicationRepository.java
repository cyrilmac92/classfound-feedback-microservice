/*
MIT License

Copyright (c) 2016 CYRIL MAC PHILIP

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 */
package com.classfound.feedback.repository;

import com.classfound.feedback.entity.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD repository for the application table.
 * Created by philic3 on 8/27/2016.
 */
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Long> {

    /**
     * Find an application by the application name.
     * @param appName the application name.
     * @return the corresponding application entity.
     */
    ApplicationEntity findByAppName(String appName);
}
