# knative-java-demo

## QUICK START

### 预先准备
1. 安装和配置 docker,kubernetes,istio,knative

### Serving
1. 构建docker镜像 
    ```
    
    cd script
    sh build_push_image.sh
    ```
2. 运行serving
    ```
    cd yaml
    kubectl apply -f serving.yaml
    ```

3. 测试服务
    ```
    kubectl get service helloworld-java
    export DOMAIN_NAME=$(kubectl get ksvc helloworld-java --output jsonpath={.status.domain})
    export IP_ADDRESS=$(kubectl get svc istio-ingressgateway --namespace istio-system --output jsonpath="{.spec.clusterIP}")
    curl -H "Host: ${DOMAIN_NAME}" http://${IP_ADDRESS}   
    ```

### Build
1. 构建

## 参考文档
https://www.knative.dev/docs/serving/samples/hello-world/helloworld-java/