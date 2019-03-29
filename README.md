# knative-java-demo

## QUICK START

1. 安装和配置 docker,kubernetes,istio,knative
2. 创建secret 
    ```
    cd yaml
    cp secret.yaml.sample secret.yaml
    vim secret.yaml
    kubectl apply -f secret.yaml
    ```
3. 创建service account
    ```
    cd yaml
    kubectl apply -f service_account.yaml
    ```

4. 构建docker镜像并推送到dockerhub
    ```
    cd yaml
    kubectl apply -f build.yaml
    ```
    
5. 拉取镜像并创建服务
    ```
    cd yaml
    kubectl apply -f service.yaml
    ```

6. 验证服务
    ```
    kubectl get service knative-java-demo
    export DOMAIN_NAME=$(kubectl get ksvc knative-java-demo --output jsonpath={.status.domain})
    export IP_ADDRESS=$(kubectl get svc istio-ingressgateway --namespace istio-system --output jsonpath="{.spec.clusterIP}")
    curl -H "Host: ${DOMAIN_NAME}" http://${IP_ADDRESS}   
    ```

## 参考文档
- https://www.knative.dev/docs/build/builds/
- https://www.knative.dev/docs/build/build-templates/
- https://www.knative.dev/docs/serving/samples/hello-world/helloworld-java/