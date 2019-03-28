# knative-java-demo

## QUICK START
1. 安装和配置 docker,kubernetes,istio,knative
2. 构建docker镜像 
    ```
    git clone https://github.com/g4seek/knative-java-demo.git
    cd script
    sh build_push_image.sh
    ```
3. 运行serving
    ```
    cd yaml
    kubectl apply -f serving.yaml
    ```

4. 测试服务
    ```
        kubectl get service
        export DOMAIN_NAME=$(kubectl get ksvc knative-java-demo --output jsonpath={.status.domain}
        export IP_ADDRESS=$(kubectl get svc $INGRESSGATEWAY --namespace istio-system --output jsonpath="{.status.loadBalancer.ingress[*].ip}")
        curl -H "Host: ${DOMAIN_NAME}" http://${IP_ADDRESS}   
    ```

## 参考文档
https://www.knative.dev/docs/serving/samples/hello-world/helloworld-java/